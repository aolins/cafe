object ServiceCharge {


  def fullBill(list: List[Menu.Item]): (BigDecimal, BigDecimal) = {

    import Menu._

    val (total, serviceCharge, limit) = list.foldLeft((BigDecimal(0), 0.0, None: Option[BigDecimal]))((acc, item) => {
      val (total, serviceCharge, limit) = acc

      val (percent, newLimit) = item match {
        case CoffeeHot => (0, None)
        case ColaCold => (0, None)
        case CheeseSandwichCold => (0.10, None)
        case SteakSandwichHot => (0.20, Some(BigDecimal(20)))
      }

      val limitServiceCharge = limit orElse newLimit

      (total + item.price, Math.max(serviceCharge, percent), limitServiceCharge)
    })

    val noLimitServiceCharge = total * serviceCharge

    val limitedServiceCharge = limit match {
      case Some(value) => {
        if (value > noLimitServiceCharge) {
          noLimitServiceCharge
        } else {
          value
        }
      }
      case _ => noLimitServiceCharge
    }

    (total + limitedServiceCharge, limitedServiceCharge)
  }


}


def isServiceChargeApplied(list: List[Menu.Item]): Boolean = {
  list.filter(!_.isDrink).nonEmpty
}

def calculateServiceChargeAmountAndLimit(list: List[Menu.Item]): (BigDecimal, Option[BigDecimal]) = {
  isServiceChargeApplied(list) match {
    case false => (0, None)
    case true => {
      list.filter(_.isHotFood).nonEmpty match {
        case true => (0.2, Some(20))
        case false => (0.1, None)
      }
    }
  }
}

def calculateServiceCharge(list: List[Menu.Item]): BigDecimal = {
  isServiceChargeApplied(list) match {
    case true => {
      val (percent, limit) = calculateServiceChargeAmountAndLimit(list)
      val total = StandardBill.calculateTotal(list)
      val noLimitServiceCharge = total * percent
      limit match {
        case None => noLimitServiceCharge
        case Some(fixedAmount) => {
          if (noLimitServiceCharge > fixedAmount) fixedAmount else noLimitServiceCharge
        }
      }
    }
    case false => 0
  }
}

}

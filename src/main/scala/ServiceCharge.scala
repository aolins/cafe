object ServiceCharge {

  def isServiceChargeApplied(list:List[Menu.Item]): Boolean = {
    list.filter(!_.isDrink).nonEmpty
  }

  def calculateServiceChargeAmountAndLimit(list: List[Menu.Item]):(BigDecimal, Option[BigDecimal]) = {
    isServiceChargeApplied(list) match {
      case false => (0, None)
      case true => {
        list.filter(_.isHotFood).nonEmpty match {
          case true => (0.2,Some(20))
          case false => (0.1,None)
        }
      }
    }
  }

  def calculateServiceCharge(list:List[Menu.Item]): BigDecimal = {
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

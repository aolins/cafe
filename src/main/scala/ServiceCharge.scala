object ServiceCharge {

  def isServiceChargeApplied(list:List[Menu.Item]): Boolean = {
    list.filter(!_.isDrink).nonEmpty
  }

  def calculateServiceChargeAmount(list: List[Menu.Item]):BigDecimal = {
    isServiceChargeApplied(list) match {
      case false => 0
      case true => {
        list.filter(_.isHotFood).nonEmpty match {
          case true => 0.2
          case false => 0.1
        }
      }
    }
  }

  def calculateServiceCharge(list:List[Menu.Item]): BigDecimal = {
    isServiceChargeApplied(list) match {
      case true => StandardBill.calculateTotal(list) * calculateServiceChargeAmount(list)
      case false => 0
    }
  }

}

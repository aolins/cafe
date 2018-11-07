object ServiceCharge {

  def isServiceChargeApplied(list:List[Menu.Item]): Boolean = {
    list.filter(!_.isDrink).nonEmpty
  }

  def calculateServiceCharge(list:List[Menu.Item]): BigDecimal = {
    isServiceChargeApplied(list) match {
      case true => StandardBill.calculateTotal(list) * 0.1
      case false => 0
    }
  }

}

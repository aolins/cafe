object ServiceCharge {

  def isServiceChargeApplied(list:List[Menu.Item]): Boolean = {
    list.filter(!_.isDrink).nonEmpty
  }

  def calculateServiceCharge(list:List[Menu.Item]): BigDecimal = ???

}

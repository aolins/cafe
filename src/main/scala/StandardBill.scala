import Menu.Item

object StandardBill {

  def calculateTotal(list:List[Item]):BigDecimal = {
    list.foldLeft(BigDecimal(0))((acc, item) => acc + item.price)
  }
}

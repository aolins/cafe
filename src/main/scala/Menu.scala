object Menu {

  case class Item(
    val price: BigDecimal,
    val name:String,
    val isDrink:Boolean = false,
    val isHotFood:Boolean = false
  )

  val CoffeeHot =  Item(1, "Coffee - Hot", true)
  val ColaCold = Item(0.5, "Cola - Cold", true)
  val CheeseSandwichCold = Item(2, "Cheese Sandwich - Cold")
  val SteakSandwichHot = Item(4.5, "Steak Sandwich - Hot", isHotFood = true)

}

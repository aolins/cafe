object Menu {

  class Item(
    val price: BigDecimal,
    val name:String,
    val isDrink:Boolean = false,
    val isHotFood:Boolean = false
  )

  object ColaCold extends Item(0.5, "Cola - Cold", true)
  object CoffeeHot extends Item(1, "Coffee - Hot", true)
  object CheeseSandwichCold extends Item(2, "Cheese Sandwich - Cold")
  object SteakSandwichHot extends Item(4.5, "Steak Sandwich - Hot", isHotFood = true)

}

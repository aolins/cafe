object Menu {

  class Item(
    val price: BigDecimal,
    val name:String
  )

  object ColaCold extends Item(0.5, "Cola - Cold")
  object CoffeeHot extends Item(1, "Coffee - Hot")
  object CheeseSandwichCold extends Item(2, "Cheese Sandwich - Cold")
  object SteakSandwichHot extends Item(4.5, "Steak Sandwich - Hot")

}

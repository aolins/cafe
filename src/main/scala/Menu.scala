object Menu {

  class Item(
    val price: BigDecimal,
    val name:String
  )

  object `Cola-Cold` extends Item(0.5, "Cola - Cold")
  object `Coffee-Hot` extends Item(1, "Coffee - Hot")
  object `Cheese Sandwich-Cold` extends Item(2, "Cheese Sandwich - Cold")
  object `Steak Sandwich-Cold` extends Item(4.5, "Steak Sandwich - Cold")

}

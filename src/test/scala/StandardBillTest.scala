import Menu._
import org.scalatest.{FlatSpec, Matchers}


class StandardBillTest  extends FlatSpec with Matchers {

  " [“Cola”, “Coffee”, “Cheese Sandwich”] " should "return 3.5" in {

    StandardBill.calculateTotal(List(ColaCold,CoffeeHot,CheeseSandwichCold)) shouldEqual BigDecimal(3.5)

  }
}


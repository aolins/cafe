import Menu.{CheeseSandwichCold, CoffeeHot, ColaCold, SteakSandwichHot}
import org.scalatest.{FlatSpec, Matchers}

class ServiceChargeTest extends FlatSpec with Matchers {

  " Drink service charge " should "be true if there is a non-drink" in {

    ServiceCharge.isServiceChargeApplied(List(ColaCold,CoffeeHot,CheeseSandwichCold)) shouldEqual true
    ServiceCharge.isServiceChargeApplied(List(SteakSandwichHot,CheeseSandwichCold)) shouldEqual true

  }
  " Drink service charge " should "be false if there are only drinks" in {

    ServiceCharge.isServiceChargeApplied(List(ColaCold,CoffeeHot)) shouldEqual false
    ServiceCharge.isServiceChargeApplied(List()) shouldEqual false
    ServiceCharge.isServiceChargeApplied(List(CoffeeHot)) shouldEqual false

  }

  "When purchased items include any food" should " apply a service charge of 10% to the total bill " in {

    val items = List(ColaCold,CoffeeHot,CheeseSandwichCold)
    val totalBill = StandardBill.calculateTotal(items)
    val serviceCharge = ServiceCharge.calculateServiceCharge(items)

    serviceCharge shouldEqual (totalBill * 0.1)

  }

  "When purchased items does not include any food" should " apply a service charge of 0 " in {

    val items = List(ColaCold,CoffeeHot)
    val totalBill = StandardBill.calculateTotal(items)
    val serviceCharge = ServiceCharge.calculateServiceCharge(items)

    serviceCharge shouldEqual 0

  }


}

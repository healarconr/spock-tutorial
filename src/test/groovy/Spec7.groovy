import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Stubs')
@Narrative('''

Spock also has native support for stubs, the same way it has for
mocks. The syntax is the following:

def callable = Stub(Callable)
callable.call() >> 'Hello world'

Or using a closure:

def callable = Stub(Callable) { call() >> 'Hello world' }

The methods of a mock can also be stubbed, but it is recommended
to use the Stub function if you are not going to define interactions.
This is a better way to communicate the intention of a test.

Stubs are used when you are not trying to test the communication
between an object and its collaborators, but the state of the former
according to the state of the latter.

Reference: http://spockframework.github.io/spock/docs/1.0/interaction_based_testing.html#_stubbing

''')
class Spec7 extends Specification {

    enum Product {

        APPLE(4600),
        BANANA(3000),
        COCONUT(3400)

        private double pricePerKg

        Product(double pricePerKg) {
            this.pricePerKg = pricePerKg
        }

        double getPricePerKg() {
            return pricePerKg
        }
    }

    class Cashier {

        private DiscountList discountList

        Cashier(DiscountList discountList) {
            this.discountList = discountList
        }

        double priceOf(Product product, double weightInKg) {
            double discount = discountList.getDiscount(product)
            return weightInKg * (product.pricePerKg * (1 - discount))
        }

    }

    interface DiscountList {

        double getDiscount(Product product)

    }

    def 'should return the full price if the product does not have discount'() {
        given:
        // TODO: Create a stub of a DiscountList that always returns zero
        // Tip: Use an underscore as argument in the getDiscount method to indicate any value
        // TODO: Create an instance of a Cashier using the stub

        when:
        // TODO: Call priceOf on the cashier with a product and a weight in Kg

        then:
        true
        // TODO: Check that the return value is equal to the product price in Kg times the weight in Kg
    }

    def 'should return the discounted price if the product has discount'() {
        given:
        // TODO: Create a stub of a DiscountList that returns a discount
        // What if you use a data pipe to provide different values for the discount?
        // TODO: Create an instance of a Cashier using the stub

        when:
        // TODO: Call priceOf on the cashier with a product and a weight in Kg

        then:
        true
        // TODO: Check that the return value is equal to the product price in Kg times the weight in Kg minus the discount
    }

}

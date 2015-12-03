import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Conditions')
@Narrative('''

Conditions are like assertions in JUnit, but easier to write. They are
just boolean expressions that are usually found in the expect and then
blocks of feature methods

Reference: http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_conditions

''')
class Spec3 extends Specification {

    def 'a list should not be empty after adding an element'() {
        given:
        def list = []

        when:
        list << 'element'

        then:
        true
        // TODO: Check that the list is not empty
    }

    def 'a reversed string should be of the same length of the original one'() {
        given:
        def string = 'Hello'

        when:
        def reversed = string.reverse()

        then:
        true
        // TODO: Check that both strings have the same length
    }

    def 'an UUID has certain pattern'() {
        when:
        def uuid = UUID.randomUUID().toString()

        then:
        true
        // TODO: Check that the uuid matches a pattern
        // Tip: Use the match operator: text ==~ /match/
    }

    def 'one is greater than zero'() {
        given:
        def one = BigDecimal.ONE
        def zero = BigDecimal.ZERO

        expect:
        true
        // TODO: Compare one an zero
        // Tip: Comparing BigDecimals is usually done with the compareTo method.
        // Groovy has an operator for that method called the spaceship operator: <=>.
        // Use it like this: (a <=> b) == 0
    }

    def 'a list, after being shuffled, still contains the same elements'() {
        given:
        def list = ['a', 'b', 'c']

        when:
        Collections.shuffle(list)

        then:
        true
        // TODO: Check that the list still contains the same elements
        // Tip: use the old function to obtain the list before being shuffled
    }

    def 'after trimming every string in a list there is no string in that list that starts or ends with a space'() {
        given:
        def strings = [' a', 'b ', ' c ']

        when:
        def trimmedStrings = strings*.trim()

        then:
        true
        // TODO: Check that trimmedStrings does not contain a string that starts or ends with a space
        // Tip 1: Use the each method with a closure, like this: list.each { println(it) }. Inside the closure every
        // element can be referenced using the keyword it. If you use this approach you need to use the assert keyword
        // inside the closure because calling a method (each) is not a boolean expression
        // Tip 2: Filter the strings that start or end with a space and check that the result size is zero. This could
        // be done in a single line and would be a boolean expression, so, no assert keyword would be required. You
        // can filter a list with the findAll method, like this: list.findAll { it != null }
    }

}

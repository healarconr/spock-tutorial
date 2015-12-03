import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('Exception conditions')
@Narrative('''

Exceptions can be tested without using rules like in JUnit or annotations
like in TestNG, and Spock offers even greater flexibility because a single
feature method can have conditions that evaluate exceptions along with any
other condition. In JUnit or TestNG this is not possible because when a
exception is thrown the control flow changes abruptly. There are workarounds
for these situations but they end up creating longer test with try and catch
blocks.

Reference: http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_exception_conditions

''')
class Spec4 extends Specification {

    static class Foo {

        void validate(String string) throws IllegalArgumentException {
            if (string != null && string.length() > 5) {
                throw new IllegalArgumentException("Illegal string: $string")
            }
        }

    }

    // The Subject annotation is used to mark the subject under test.
    // It is optional and its use is just informative
    @Subject
    def foo = new Foo()

    def 'should throw an IllegalArgumentException if the length of the string is greater than 5'() {
        when:
        // TODO: Call the validate method of the subject using an invalid string

        then:
        true
        // TODO: Check that the correct type of exception is thrown including its message
        // Tip: Use the thrown function
    }

    def 'should not throw any exception if the string is null'() {
        when:
        // TODO: Call the validate method of the subject with a null string

        then:
        true
        // TODO: Check that no exception is thrown
        // Tip: Use the notThrown function
    }

    def 'should throw an UnsupportedOperationException and the list should not be altered'() {
        given:
        def list = Collections.unmodifiableList(['a', 'b', 'c'])

        when:
        list << 'd'

        then:
        true
        // TODO: Check that the list was not altered
        // TODO: Check that an UnsupportedOperationException is thrown
        // Tip: Use the old function for the first one
        // This is a case that cannot be implemented directly in JUnit or TestNG because
        // the control flow is altered when an exception is thrown. Also notice
        // that there is no need to check the thrown exception first. Spock defers the
        // evaluation of that condition, but if you remove it the test will fail. Try
        // removing it an you will see.
    }

}

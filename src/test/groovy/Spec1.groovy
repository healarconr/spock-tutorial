import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Fixture methods')
@Narrative('''

In this spec your have to define four
fixture methods (setup, cleanup, setupSpec and cleanupSpec)
and see in which order they are executed.

Tip: Use println to print a string to the standard output, like this:

println 'Hello world'

Reference: http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_fixture_methods

''')
class Spec1 extends Specification {

    // TODO: Define the setup fixture method

    // TODO: Define the cleanup fixture method

    // TODO: Define the setupSpec fixture method

    // TODO: Define the cleanupSpec fixture method

    def 'one should be equal to one'() {
        expect:
        1 == 1
    }

    def 'two should be equal to two'() {
        expect:
        2 == 2
    }

}

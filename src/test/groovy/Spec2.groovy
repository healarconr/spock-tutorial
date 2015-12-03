import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Fields')
@Narrative('''

In the Spec1 you defined a setup fixture method. That method is
called before every feature method and it's useful to instantiate
objects and configure them before they are used in a feature
method. But there is another way to do that. If you just need to
instantiate an object you can define a field and assign a value
to it. That's equivalent to do it in a setup method.

Tip: Use the system time as the initialization value of the field, that way
you will see the change in the output

Reference: http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_fields

''')
class Spec2 extends Specification {

    // TODO: Define a field and assign a value to it

    def 'one should be equal to one'() {
        setup:
        // TODO: print the field value to the standard output

        expect:
        1 == 1
    }

    def 'two should be equal to two'() {
        setup:
        // TODO: print the field value to the standard output

        expect:
        2 == 2
    }

}

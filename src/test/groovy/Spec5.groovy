import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('Mocks')
@Narrative('''

Spock has native support for mocks. There is no need to add extra
libraries like Mockito or EasyMock.

Mocks are a category of test doubles that are used to verify
the interaction of a subject with its collaborators. They are defined
using the Mock function, like this:

def runnable = Mock(Runnable)

In Groovy there is no need to type .class after the class name.

The general question to answer using mocks is: How many times a specific method
is called with certain arguments and in certain moment?

The way you answer that question in Spock is defining interactions.
An interaction has the following structure:

1 * subscriber.receive("hello")
|   |          |       |
|   |          |       argument constraint
|   |          method constraint
|   target constraint
cardinality

There is a whole chapter about interaction based testing in the
Spock reference, and here we are just going to see some examples.

Reference: http://spockframework.github.io/spock/docs/1.0/interaction_based_testing.html

''')
class Spec5 extends Specification {

    static class Foo {

        void consume(String string, Consumer<String> consumer) {
            consumer.accept(string)
        }

        void consume(Set<String> strings, Consumer<String> consumer) {
            strings.each { consumer.accept(it) }
        }

        void consume(String string, Set<Consumer<String>> consumers) {
            consumers.sort { new Random().nextInt() }.first().accept(string)
        }

        void notify(int n, Listener listener) {
            (1..n).each { listener.somethingHappened() }
        }

        void consumeAndNotify(String string, Consumer<String> consumer, Listener listener) {
            consumer.accept(string)
            listener.somethingHappened()
        }

    }

    interface Consumer<T> {

        void accept(T arg)

    }

    interface Listener {

        void somethingHappened()

    }

    @Subject
    def foo = new Foo()

    def 'should call accept on the consumer with the same string provided as argument'() {
        given:
        // TODO: Create a mock of a Consumer

        when:
        // TODO: Call consume on the subject with a string and the consumer

        then:
        true
        // TODO: Verify that the accept method on the consumer is called once with the correct argument
    }

    def 'should call accept on the consumer as many times as strings are in the set'() {
        given:
        // TODO: Create a mock of a Consumer

        when:
        // TODO: Call consume on the subject with a set of strings and the consumer

        then:
        true
        // TODO: Verify that the accept method on the consumer is called once for every string you passed
        // Tip: Use the each function and write the interaction inside the closure
    }

    def 'should call somethingHappened on the listener as many times as the argument passed'() {
        given:
        // TODO: Create a mock of a Listener

        when:
        // TODO: Call notify on the subject with a positive integer and the listener

        then:
        true
        // TODO: Verify that the somethingHappened method on the consumer is called the same number of times as you indicated
    }

    def 'should call accept on one of the consumers'() {
        given:
        // TODO: Create a set of mocks of Consumer

        when:
        // TODO: Call consume with a string and the set of mocks

        then:
        true
        // TODO: Verify that the accept method is called in one of the mocks
        // Tip: Use an underscore in the target constraint to indicate any mock
    }

    def 'should call accept on the consumer and then somethingHappened in the listener'() {
        given:
        // TODO: Create a mock of a Consumer
        // TODO: Create a mock of a Listener

        when:
        // TODO: Call consumeAndNotify with a string and the mocks

        then:
        true
        // TODO: Verify that the accept method is called

        // This and is optional, it does not impose any ordering
        and:

        then:
        true
        // TODO: Verify that the somethingHappened method is called
        // If the invocation order is important splitting the interactions in
        // several then blocks guarantees that the order is followed
    }

}

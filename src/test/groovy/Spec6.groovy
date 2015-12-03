import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import java.text.SimpleDateFormat

@Title('Data-driven tests')
@Narrative('''

Sometimes you need to create data sets to test some methods.
You can be interested in verifying that a validation or a computation is
correct. Spock offers a really cool feature that allows you to define
these data sets using a table-like structure.

This is done inside a where block that must be placed at the end
of a feature method. For example:

  def 'max of two numbers'(int a, int b, int c) {
    expect:
    Math.max(a, b) == c

    where:
      a | b | c
      1 | 3 | 3
      7 | 4 | 7
      0 | 0 | 0
  }

This feature also has an entire chapter in the reference documentation.

Reference: http://spockframework.github.io/spock/docs/1.0/data_driven_testing.html

''')
class Spec6 extends Specification {

    enum RockPaperScissors {

        ROCK(SCISSORS), PAPER(ROCK), SCISSORS(PAPER)

        private RockPaperScissors beaten

        private RockPaperScissors(RockPaperScissors beaten) {
            this.beaten = beaten
        }

        private boolean beats(RockPaperScissors b) {
            b == beaten
        }

        static RockPaperScissors winner(RockPaperScissors a, RockPaperScissors b) {
            a.beats(b) ? a : b.beats(a) ? b : null
        }

    }

    static class Validator {

        static boolean isNullOrEmpty(String string) {
            string == null || string.empty
        }

        static boolean isInTheCurrentEra(Date date) {
            !(new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSSX').parse('0000-00-00T00:00:00.000-00:00').before(date))
        }

    }

    def 'should find the winner in a rock-paper-scissors game'() {
        expect:
        true
        // TODO: Call the winner method on RockPaperScissors with two arguments

        where:
        a | b || winner
        // TODO: Complete the table with the different combinations (and permutations) of a game
        // Use null to indicate a tie
        // Notice that two bars can be used to visually separate inputs from
        // expected outputs.
        // Also notice that IntelliJ IDEA understands this structure and can format
        // the table. The result is really nice.
    }

    def 'should return false if the string is null or empty'() {
        expect:
        true
        // TODO: Call isNullOrEmpty on the Validator and check that the return value is false

        where:
        a = 1
        // TODO: Define a list of strings with two values: null and an empty string
        // Tip: Sometimes a list is enough to define the data we need.
        // These lists are actually called data pipes in Spock and they are defined like this:
        // string << [ 'a', 'b', 'c' ]
        // You could read it like: use the values 'a', 'b' and 'c' for the variable string, each
        // one in a different iteration
    }

    def 'should return false if a date is not in the current era'() {
        expect:
        true
        // TODO: Call isInTheCurrentEra on the Validator and check that the return value is false

        where:
        a = 1
        // TODO: Define a list of strings with dates in the current era
        // TODO: Parse every string into a Date
        // Tip: Sometimes we need to perform some transformations on the test data.
        // In this case is easier to write dates as strings but we need Date objects for the
        // test. You can define a data pipe the same way you did it in the previous feature method,
        // but now we need to parse the strings by adding a data variable assignment. Example:
        // lowerCase << ['a', 'b', 'c'] // Data pipe
        // uppercase = lowerCase.toUpperCase() // Data variable assignment
    }

}

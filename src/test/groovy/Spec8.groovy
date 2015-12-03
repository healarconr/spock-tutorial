import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('Everything combined')
@Narrative('''

The idea is to implement a toy version of Mobilizer. It has a single feature:
it allows a client to find a list of routes from an origin to a destination.
To simplify things concepts like origin, destination and route are represented
just as strings. A real version could abstract origins and destinations as
points with latitude and longitude and a route as a list of segments, each one
with an start and end point, but also a duration and a type (walking segment,
a bus riding segment, etc.)

You should start writing feature method by feature method and modify the implementation
just enough to keep all the feature methods passing. When they all pass you can
refactor the implementation to make it prettier, and because you already have
a means to test that it works you can do it safely.

Some of the concepts from Spock that you probably want to use here are:

- Fields or setup fixture method
- Thrown function
- Data pipe
- Data table
- Condition
- Interaction
- Mock
- Stub

''')
class Spec8 extends Specification {

    class Mobilizer {

        private List<RouteCalculator> routeCalculators
        private RouteSorter routeSorter

        Mobilizer(List<RouteCalculator> routeCalculators, RouteSorter routeSorter) {
            // TODO: Implement this constructor
        }

        List<String> findRoutes(String origin, String destination) {
            // TODO: Implement this method
        }

    }

    interface RouteCalculator {

        String calculateRoute(String origin, String destination)

    }

    interface RouteSorter {

        List<String> sort(List<String> routes)

    }

    def 'should not accept a null or empty list of route calculators'() {
        // TODO: Implement this feature method
    }

    def 'should not accept a null route sorter'() {
        // TODO: Implement this feature method
    }

    def 'should not accept a null origin'() {
        // TODO: Implement this feature method
    }

    def 'should not accept a null destination'() {
        // TODO: Implement this feature method
    }

    def 'should call calculateRoute on every route calculator'() {
        // TODO: Implement this feature method
    }

    def 'should call sort on the route sorter with the list of routes obtained from the route calculators'() {
        // TODO: Implement this feature method
    }

    def 'should return the sorted routes'() {
        // TODO: Implement this feature method
    }

}

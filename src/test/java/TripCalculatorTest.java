
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class TripCalculatorTest {

    public TripCalculator trip;

    @Before
    public void setUp() throws Exception {
        trip = new TripCalculator();
    }

    @Test
    public void testReadRoutes() throws Exception
    {
        ArrayList<Route> routes =  trip.readRoutes();

        for (int i = 0; i < routes.size(); i++)
        {
            System.out.println(""+routes.get(i));
        }
    }

    @Test
    public void testReadSpritDB() throws Exception {
        trip.readSpritDB();
    }

    @Test
    public void testCalculateConsumtion() throws Exception
    {
        Route r = new Route(10, 5, 1, 5);
        assertThat(trip.calculateComsumption(r), equalTo(6.625));
    }
}


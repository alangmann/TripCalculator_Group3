
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


public class TripCalculatorTest {

    public TripCalculator trip;

    @org.junit.Before
    public void setUp() throws Exception {
        trip = new TripCalculator();
    }

    @org.junit.Test
    public void testReadRoutes() throws Exception
    {
        ArrayList<Route> routes =  trip.readRoutes();

        for (int i = 0; i < routes.size(); i++)
        {
            System.out.println(""+routes.get(i));
        }
    }

    @org.junit.Test
    public void testReadSpritDB() throws Exception {
        trip.readSpritDB();
    }
}


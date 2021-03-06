
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
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
        assertThat(trip.readRoutes().get(0), equalTo(new Route(10,5,1,5)));
    }

    @Test
    public void testReadSpritDB() throws Exception {

        ArrayList<Sprit> spritList = trip.readSpritDB();
        assertThat(spritList.get(1).getDay()+";"+spritList.get(1).getDiesel() +";"+spritList.get(1).getPatrol(), equalTo("Wednesday;1.299;1.387"));
    }

    @Test
    public void testCalculateConsumption() throws Exception
    {
        Route r = new Route(10, 5, 1, 5);
        Truck t = new Truck(10000, Vehicle.fuelType.PATROL, 3126, 6, true);
        assertThat(trip.calculateConsumption(r, t), equalTo(6.625000000000001));
        // Mit 6,625 als erwartetes Ergebnis wird ein Fehler zurückgegeben.
    }

    @Test
    public void testCalculateConsumptionWithNegSlope() throws Exception
    {
        Route r = new Route(10, -15, 2, 5);
        Car c = new Car(1000, Vehicle.fuelType.DIESEL, 123);
        assertThat(trip.calculateConsumption(r,c), equalTo(-0.0));

        //Anscheinend ergibt es ein -0.0 da eine negative Zahl dabei ist? Mit 0.0 wird ein Fehler zurückgegeben.
    }

    @Test
    public void testCalculateCostofRoute() throws Exception
    {
        Route r = new Route(10, 5, 1, 5);
        Car c = new Car(1000, Vehicle.fuelType.DIESEL, 123);

        //(Route r, Vehicle v, String dayOfWeek, double slope, int cargo, String typeOfFuel)
        Assert.assertThat(trip.calculateCostOfRoute(r, c, "Monday", 1.2, 123, Vehicle.fuelType.DIESEL.toString()), equalTo(-1.0));
    }

    @Test
    public void testConsumptionWithNormalRoute() throws Exception
    {
        Route r = new Route(10, 5, 2, 5);
        Car c = new Car(1000, Vehicle.fuelType.DIESEL, 123);
        assertThat(trip.calculateConsumption(r,c), equalTo(16.25));
    }
}


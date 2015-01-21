import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;



public class TripCalculatorGUITest extends TestCase
{
    public TripCalculatorGUI trip;

    @Before
    public void setUp() throws Exception {
        trip = new TripCalculatorGUI();
        trip.initialize();
    }

    public void testAccept() throws Exception
    {
        trip.onAccept();
    }




}
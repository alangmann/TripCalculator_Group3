import static org.hamcrest.MatcherAssert.assertThat;


import beans.TripCalculatorGUI;
import junit.framework.TestCase;
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
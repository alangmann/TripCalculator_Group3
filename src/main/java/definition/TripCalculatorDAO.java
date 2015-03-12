package definition;

import beans.Sprit;
import beans.Route;
import beans.Vehicle;

import java.util.ArrayList;

/**
 * Created by Dominik on 05.02.2015.
 */
public interface TripCalculatorDAO
{
    public ArrayList<Route> readRoutes();

    public ArrayList<Sprit> readSpritDB();

    public double calculateConsumption(Route r, Vehicle v);

    public double calculateCostOfRoute(Route r, Vehicle v, String dayOfWeek, double slope, int cargo, String typeOfFuel);
}

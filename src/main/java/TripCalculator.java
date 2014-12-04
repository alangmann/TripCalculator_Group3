/**
 * Created by andreas.langmann on 12.11.2014.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TripCalculator {

    // TODO: implement me :)
    // test
    private ArrayList<Route> readRoutes() throws Exception
    {
        ArrayList<Route> routes = new ArrayList<Route>();
        String path = System.getProperty("Usr.src")+File.separator+"main"+File.separator+"resources";
        System.out.println(path);
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = "";
        while(!(line=br.readLine()).equals(null))
        {
            Route r;

            String[] lines  = line.split(";");

            if(lines[3].equals(r.getTypeOfRoute().Highway))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getTypeOfRoute().Highway);
                routes.add(r);
            }
            else if (lines[3].equals(r.getRouteType().CountryRoad))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getTypeOfRoute().CountryRoad);
                routes.add(r);
            }
            else
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getTypeOfRoute().GravelRoad);
                routes.add(r);
            }

        }

        return routes;

    }

    private void readSpritDB()
    {
        ArrayList<String, double, double> spritList = new ArrayList<String, double, double>();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = "";


        while(!(line=br.readLine().equals(null)))
        {
            //Aufbau= Tag;Diesel;Benzin
            String[] lines = line.split(";");
            if(!lines[1].equals("Diesel"))
            {
                spritList.add(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2]));
            }
        }

    }


}

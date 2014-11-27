/**
 * Created by andreas.langmann on 12.11.2014.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

            if(lines[3].equals(r.getRouteType().Highway))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getRouteType().Highway);
                routes.add(r);
            }
            else if (lines[3].equals(r.getRouteType().CountryRoad))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getRouteType().CountryRoad);
                routes.add(r);
            }
            else
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), r.getRouteType().GravelRoad);
                routes.add(r);
            }


        }

        return routes;

    }


}

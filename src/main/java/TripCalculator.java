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
            Route r = new Route();

            String[] lines  = line.split(";");

            if(lines[2].equals(r.getTypeOfRoute().Highway))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), 1, Double.parseDouble(lines[3]));
                routes.add(r);
            }
            else if (lines[2].equals(r.getTypeOfRoute().CountryRoad))
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), 1.2, Double.parseDouble(lines[3]));
                routes.add(r);
            }
            else
            {
                r = new Route(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), 2, Double.parseDouble(lines[3]));
                routes.add(r);
            }

        }

        return routes;

    }

    private void readSpritDB() throws Exception
    {
        ArrayList<Sprit> spritList = new ArrayList<Sprit>();

        String path = System.getProperty("Usr.src")+File.separator+"main"+File.separator+"resources";
        System.out.println(path);
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = "";
        while(!(line=br.readLine()).equals(null))
        {
            //Aufbau= Tag;Diesel;Benzin
            String[] lines = line.split(";");
            if(!lines[1].equals("Diesel"))
            {
                spritList.add(new Sprit(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2])));
            }
        }

    }

    private double calculateComsumption(Route r)
    {
        double co2 = 0.1325;


        // Berechnung: km x CO2 x slope x Factor of Route type
        double comsumption = r.getDistance() * co2 * r.getSlope() * r.getRouteType();

        return comsumption;
    }


}

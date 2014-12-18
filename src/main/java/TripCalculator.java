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
    public ArrayList<Route> readRoutes() throws Exception
    {
        ArrayList<Route> routes = new ArrayList<Route>();
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"routes.csv";
        System.out.println(path);
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = "";
        String line1=null;
        while ((line1 = br.readLine()) != null && !(line=br.readLine()).equals(null))
        {
            Route r = new Route();

            String[] lines  = line.split(";");



            if(lines[2].equals(r.getTypeOfRoute().Highway))
            {
                r = new Route(Double.parseDouble(lines[0].replace(',', '.')), Double.parseDouble(lines[1].replace(',', '.')), 1, Double.parseDouble(lines[3].replace(',', '.')));
                routes.add(r);
            }
            else if (lines[2].equals(r.getTypeOfRoute().CountryRoad))
            {
                r = new Route(Double.parseDouble(lines[0].replace(',', '.')), Double.parseDouble(lines[1].replace(',', '.')), 1.2, Double.parseDouble(lines[3].replace(',', '.')));
                routes.add(r);
            }
            else
            {
                r = new Route(Double.parseDouble(lines[0].replace(',', '.')), Double.parseDouble(lines[1].replace(',', '.')), 2, Double.parseDouble(lines[3].replace(',', '.')));
                routes.add(r);
            }

        }

        return routes;

    }

    public void readSpritDB() throws Exception
    {
        ArrayList<Sprit> spritList = new ArrayList<Sprit>();

        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"sprit_db.csv";
        System.out.println(path);
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = "";
        String line1=null;
        while ((line1 = br.readLine()) != null &&!(line=br.readLine()).equals(null))
        {
            //Aufbau= Tag;Diesel;Benzin
            String[] lines = line.split(";");
            if(!lines[1].equals("Diesel"))
            {
                spritList.add(new Sprit(lines[0], Double.parseDouble(lines[1]), Double.parseDouble(lines[2])));
            }
        }

    }

    public double calculateComsumption(Route r, Vehicle v)
    {
        double co2 = 0.1325;

        // Berechnung: km x CO2 x slope x Factor of Route type

        double comsumption;
        if(r.getSlope()<=-5)
        {
            comsumption = r.getDistance() * 0 * r.getSlope() * r.getRouteType();
        }
        else {

            comsumption = r.getDistance() * co2 * r.getSlope() * r.getRouteType();
        }

        return comsumption;
    }


}

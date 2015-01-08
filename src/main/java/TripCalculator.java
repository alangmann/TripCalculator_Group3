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

    public ArrayList<Sprit> readSpritDB() throws Exception
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
        return spritList;

    }

    public double calculateConsumption(Route r, Vehicle v)
    {
        double co2 = 0.1325;

        // Berechnung: km x CO2 x slope x Factor of Route type
        
        double consumption=0;
        if(r.getSlope()<=-5)
        {
            consumption = r.getDistance() * 0 * r.getSlope() * r.getRouteType();
        }
        else {
            if(v instanceof Car)
            {
                // Calculation for car
                consumption = r.getDistance() * co2 * r.getSlope() * r.getRouteType() + v.getCargo()/100*0.5;
            }
            else
            {   // Calculation for truck
                consumption = r.getDistance() * co2 * r.getSlope() * r.getRouteType() + v.getCargo()/100*0.05;
            }

        }

        return consumption;
    }

    // Methode unvollständig!!
    public double calculateCostOfRoute(Route r, Vehicle v, String dayOfWeek, double slope, int cargo, String typeOfFuel)
    {
        double spritCost = 0;
        try
        {
            ArrayList<Sprit> spritList = this.readSpritDB();
            for(Sprit s : spritList)
            {
                if(s.getDay().equals(dayOfWeek))
                {
                    if(typeOfFuel.equals("DIESEL"))
                    {
                        spritCost = s.getDiesel();
                    }
                    else spritCost = s.getPatrol();
                }
            }

            double cost=0.0;
            double averageC = 35;
            cost = r.getDistance()*(averageC/100)*spritCost+r.getSpecialFee();

            return cost;
        }
        catch(Exception ex)
        {
            System.out.println("Fehler beim Einlesen der SpritDB!");
        }


        return -1;
    }


}

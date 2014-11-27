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
            line.split(";");



            r = new Route(Integer.parseInt(line[0]), Integer.parseInt(line[1]), );

        }


    }


}

/**
 * Created by andreas.langmann on 12.11.2014.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TripCalculator {

    // TODO: implement me :)
    // test
    private void readRoutes() throws FileNotFoundException
    {
        String path = System.getProperty("Usr.src")+File.separator+"main"+File.separator+"resources";
        System.out.println(path);
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = "";
        while(!(line=br.readLine()).equals(null))
        {

        }
    }


}

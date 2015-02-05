import org.springframework.stereotype.Repository;

/**
 * Created by Dominik on 27.11.2014.
 */

public class Truck extends Vehicle {
    int axels;
    boolean adBlue;

    public Truck(int cargo, fuelType typeOfFuel, double averageConsumption, int axels, boolean adBlue) {
        super(cargo, typeOfFuel, averageConsumption);
        this.axels = axels;
        this.adBlue = adBlue;
    }
}

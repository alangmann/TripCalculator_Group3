import javax.annotation.Resource;

/**
 * Created by Dominik on 27.11.2014.
 */

@Repository("Car")
public class Car extends Vehicle
{

    public Car(int cargo, fuelType typeOfFuel, double averageConsumption) {
        super(cargo, typeOfFuel, averageConsumption);
    }
}

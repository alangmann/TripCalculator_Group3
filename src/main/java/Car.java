/**
 * Created by Dominik on 27.11.2014.
 */

@Repository("CarDAO")

public class Car extends Vehicle {

    public Car(int cargo, fuelType typeOfFuel, double averageConsumption) {
        super(cargo, typeOfFuel, averageConsumption);
    }
}

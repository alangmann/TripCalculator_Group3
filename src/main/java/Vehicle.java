import org.springframework.stereotype.Repository;

/**
 * Created by Dominik on 27.11.2014.
 */

public class Vehicle {
    private double averageConsumption;
    private fuelType typeOfFuel;
    int cargo;

    public enum fuelType {
        DIESEL, PATROL
    }

    public Vehicle(int cargo, fuelType typeOfFuel, double averageConsumption) {
        this.cargo = cargo;
        this.typeOfFuel = typeOfFuel;
        this.averageConsumption = averageConsumption;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(double averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

    public fuelType getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(fuelType typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}

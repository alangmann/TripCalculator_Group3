package beans;

/**
 * Created by Dominik on 04.12.2014.
 */

public class Sprit {
    String day;
    double diesel;
    double patrol;

    public Sprit(String day, double diesel, double patrol) {
        this.day = day;
        this.diesel = diesel;
        this.patrol = patrol;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getDiesel() {
        return diesel;
    }

    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }

    public double getPatrol() {
        return patrol;
    }

    public void setPatrol(double patrol) {
        this.patrol = patrol;
    }
}

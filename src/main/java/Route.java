/**
 * Created by Dominik on 27.11.2014.
 */
public class Route
{
    // Beispiel: km;slope;routtype;special fee

    private double distance;
    private int slope;
    private RouteType typeOfRoute;
    private double specialFee;
    private double routeType;

    public Route(double distance, int slope, double routeType, double specialFee) {
        this.distance = distance;
        this.slope = slope;
        this.routeType = routeType;
        this.specialFee = specialFee;
    }

    public Route()
    {

    }

    public enum RouteType {
        Highway, CountryRoad, GravelRoad
    }

    public double getRouteType()
    {
        return routeType;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }

    public RouteType getTypeOfRoute() {
        return typeOfRoute;
    }

    public void setTypeOfRoute(RouteType typeOfRoute) {
        this.typeOfRoute = typeOfRoute;
    }

    public double getSpecialFee() {
        return specialFee;
    }

    public void setSpecialFee(double specialFee) {
        this.specialFee = specialFee;
    }

    public double getDistance() {

        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

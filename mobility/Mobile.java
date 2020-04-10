package mobility;
import java.lang.Math;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 * Represents Mobile attributes
 */
public abstract class Mobile implements ILocatable{
    private Point location = new Point();
    private double totalDistance;

    /**
     * Default constructor (with proper values)
     */
    public Mobile(){
        this.totalDistance = 0; // total Distance start at 0
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Mobile(Point location){
        setLocation(location); // Updating the point location;
        this.totalDistance = 0; // total Distance start at 0
    }

    /**
     * Returns the attributes as a string
     */
    public String toString(){
        return "location point: " + getLocation() + " ,totalDistance: " + this.totalDistance;
    }

    /**
     * Updating total distance
     */
    public void addTotalDistance(double distance){
        this.totalDistance += distance;
    }

    /**
     * Calculate the distance between the points
     */
    public double calcDistance(Point other){
        return Math.sqrt((location.getY() - other.getY()) * (location.getY() - other.getY()) +
                (location.getX() - other.getX()) * (location.getX() - other.getX()));
    }

    /**
     * move the object
     */
    public double move(Point move_to){
        double distance = calcDistance(move_to); // Calculate the distance between the points
        addTotalDistance(distance); // Updating Total Distance
        setLocation(move_to); // Updating the point location
        return distance;
    }

    /**
     * get the Location
     */
    public Point getLocation() {
        return new Point(location.getX(),location.getY()); // Returns point with identical values to the location
    }

    /**
     * set the Location
     */
    public boolean setLocation(Point point) {
        this.location.setX(point.getX()); // Updating the X values
        this.location.setY(point.getY()); // Updating the Y values
        return true;
    }
}

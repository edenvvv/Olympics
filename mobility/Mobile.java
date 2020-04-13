package mobility;
import java.lang.Math;

/**
 * Class that describes an Mobile attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public abstract class Mobile implements ILocatable{
    private Point location ;
    private double totalDistance;

    /**
     * Default constructor (with proper values)
     */
    public Mobile(){
        this.location = new Point();
        this.totalDistance = 0; // total Distance start at 0
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param location
     */
    public Mobile(Point location){
        this.location = new Point(location.getX(),location.getY()); // Updating the point location;
        this.totalDistance = 0; // total Distance start at 0
    }

    /**
     * returns the attributes as a string
     * @return string with the attributes
     */
    public String toString(){
        return "location point: " + getLocation() + " ,totalDistance: " + this.totalDistance;
    }

    /**
     * Updating total distance
     * @param distance
     */
    public void addTotalDistance(double distance){
        this.totalDistance += distance;
    }

    /**
     * Calculate the distance between the points
     * @param other
     * @return the distance
     */
    public double calcDistance(Point other){
        return Math.sqrt((location.getY() - other.getY()) * (location.getY() - other.getY()) +
                (location.getX() - other.getX()) * (location.getX() - other.getX()));
    }

    /**
     * move the object
     * @param move_to
     * @return the new distance
     */
    public double move(Point move_to){
        double distance = calcDistance(move_to); // Calculate the distance between the points
        addTotalDistance(distance); // Updating Total Distance
        setLocation(move_to); // Updating the point location
        return distance;
    }

    /**
     * get the Location by point
     * @return location - point
     */
    public Point getLocation() {
        return new Point(location.getX(),location.getY()); // Returns point with identical values to the location
    }

    /**
     * set the Location
     * @param point
     * @return true if succeed, false if isn't
     */
    public boolean setLocation(Point point) {
        this.location.setX(point.getX()); // Updating the X values
        this.location.setY(point.getY()); // Updating the Y values
        return true;
    }
}

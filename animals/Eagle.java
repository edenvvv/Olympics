package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Eagle attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Eagle extends AirAnimal{
    private double altitudeOfFlight;
    static final int MAX_ALTITUDE = 1000;

    /**
     * Default constructor (with proper values)
     */
    public Eagle(){
        super();
        this.altitudeOfFlight = 8.8;
        super.set_sound("Clack-wack-chack");
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     * @param wingspan
     * @param altitudeOfFlight
     */
    public Eagle(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double wingspan,double altitudeOfFlight){
        super(name, my_genders, weight, speed, medals, position,wingspan);
        if (altitudeOfFlight > MAX_ALTITUDE){
            this.altitudeOfFlight = MAX_ALTITUDE;
        }
        else {
            this.altitudeOfFlight = altitudeOfFlight;
        }
        super.set_sound("Clack-wack-chack");
    }

    /**
     * Get the altitude of the flight of the eagle
     * @return altitude
     */
    public double get_altitudeOfFlight(){
        return this.altitudeOfFlight;
    }

    /**
     * Set the Weight of the eagle
     * @param new_altitudeOfFlight
     * @return true if succeed, false if isn't
     */
    public boolean set_weight(double new_altitudeOfFlight){
        if(new_altitudeOfFlight <= MAX_ALTITUDE){
            this.altitudeOfFlight = new_altitudeOfFlight;
            return true;
        }
        return false;
    }

    /**
     * Returns the attributes as a string
     * @return string with the attributes
     */
    public String toString()
    {
        return "altitudeOfFlight: " + this.altitudeOfFlight  + ", " + super.toString();
    }
}

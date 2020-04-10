package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Elder Dagan id: 208061580
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
        this.sound = "Clack-wack-chack";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Eagle(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double wingspan,double altitudeOfFlight){
        super(name, my_genders, weight, speed, medals, position,wingspan);
        if (altitudeOfFlight > MAX_ALTITUDE){
            this.altitudeOfFlight = MAX_ALTITUDE;
        }
        else {
            this.altitudeOfFlight = altitudeOfFlight;
        }
        this.sound = "Clack-wack-chack";
    }

    /**
     *
     */
    public double get_altitudeOfFlight(){
        return this.altitudeOfFlight;
    }

    /**
     *
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
     */
    public String toString()
    {
        return "altitudeOfFlight: " + this.altitudeOfFlight  + ", " + super.toString();
    }
}

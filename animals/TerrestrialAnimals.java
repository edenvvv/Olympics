package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Terrestrial Animals attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public abstract class TerrestrialAnimals extends Animal{
    private int noLegs;

    /**
     * Default constructor (with proper values)
     */
    public TerrestrialAnimals(){
        super();
        super.set_position(new Point(0,20));
        this.noLegs = 4;
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     * @param noLegs
     */
    public TerrestrialAnimals(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs){
        super(name, my_genders, weight, speed, medals, position);
        if(noLegs > 0) {
            this.noLegs = noLegs;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.noLegs = 4;
        }
    }


    /**
     * Get the num of the legs of the TerrestrialAnimals
     * @return number of legs
     */
    public double get_num_of_legs(){
        return this.noLegs;
    }

    /**
     * Set the num of the legs of the TerrestrialAnimals
     * @param new_noLegs
     * @return true if succeed, false if isn't
     */
    public boolean set_num_of_legs(int new_noLegs){
        if(new_noLegs > 0){
            this.noLegs = new_noLegs;
            return true;
        }
        return false;
    }

    /**
     * returns the attributes as a string
     * @return string with the attributes
     */
    public String toString()
    {
        return "number of Legs: " + this.noLegs + "," + super.toString() ;
    }
}

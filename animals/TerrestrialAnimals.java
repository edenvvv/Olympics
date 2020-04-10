package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
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
     */
    public TerrestrialAnimals(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs){
        super(name, my_genders, weight, speed, medals, position);
        this.noLegs = noLegs;
    }


    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "number of Legs: " + this.noLegs + "," + super.toString() ;
    }
}

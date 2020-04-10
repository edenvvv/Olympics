package animals;

import Olympics.Medal;
import mobility.Point;

/**
 *  eden dadon id:207279183
 *  Eliran Dagan id: 208061580
 */
public abstract class AirAnimal extends Animal {
    private double wingspan;

    /**
     * Default constructor (with proper values)
     */
    public AirAnimal(){
        super();
        super.set_position(new Point(0,100));
        this.wingspan = 0.8;

    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public AirAnimal(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double wingspan){
        super(name, my_genders, weight, speed, medals, position);
        this.wingspan = wingspan;

    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "wingspan: " + this.wingspan + super.toString();
    }
}

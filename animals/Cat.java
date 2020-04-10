package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public class Cat extends TerrestrialAnimals{
    private boolean Castrated;

    /**
     * Default constructor (with proper values)
     */
    public Cat(){
        super();
        this.Castrated = true;
        this.sound = "Meow";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Cat(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, boolean Castrated){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        this.Castrated = Castrated;
        this.sound = "Meow";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "castrated: " + this.Castrated  + ", " + super.toString();
    }
}

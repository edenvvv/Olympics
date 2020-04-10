package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public class Dog extends TerrestrialAnimals{
    private String breed;

    /**
     * Default constructor (with proper values)
     */
    public Dog(){
        super();
        this.breed = "None";
        this.sound = "Woof Woof";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Dog(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, String breed){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        this.breed = breed;
        this.sound = "Woof Woof";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "breed: " + this.breed + ", " + super.toString() ;
    }

}

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public class Whale extends WaterAnimal{
    private String foodType;

    /**
     * Default constructor (with proper values)
     */
    public Whale(){
        super();
        this.foodType = "plankton";
        this.sound = "Splash";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Whale(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, String foodType){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        this.foodType = foodType;
        this.sound = "Splash";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "foodType: " + this.foodType  + ", " + super.toString();
    }
}

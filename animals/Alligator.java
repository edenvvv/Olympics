package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public class Alligator extends WaterAnimal{
    private String AreaOfLiving;

    /**
     * Default constructor (with proper values)
     */
    public Alligator(){
        super();
        this.AreaOfLiving = "Lake";
        this.sound = "Roar";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Alligator(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, String AreaOfLiving){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        this.AreaOfLiving = AreaOfLiving;
        this.sound = "Roar";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "AreaOfLiving: " + this.AreaOfLiving  + ", " + super.toString();
    }
}

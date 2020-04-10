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
        if(AreaOfLiving.length() > 0) {
            this.AreaOfLiving = AreaOfLiving;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.AreaOfLiving = "Lake";
        }
        this.sound = "Roar";
    }


    /**
     *
     */
    public String get_AreaOfLiving(){
        return this.AreaOfLiving;
    }

    /**
     *
     */
    public boolean set_AreaOfLiving(String new_AreaOfLiving){
        if(new_AreaOfLiving.length() > 0){
            this.AreaOfLiving = new_AreaOfLiving;
            return true;
        }
        return false;
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "AreaOfLiving: " + this.AreaOfLiving  + ", " + super.toString();
    }
}

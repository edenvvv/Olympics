package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Class that describes an Alligator attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Alligator extends WaterAnimal{
    private String AreaOfLiving;

    /**
     * Default constructor (with proper values)
     */
    public Alligator(){
        super();
        this.AreaOfLiving = "Lake";
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     * @param diveDept
     * @param AreaOfLiving
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

    }


    /**
     * method that returns the value of the area of living
     * @return the area of living
     */
    public String get_AreaOfLiving(){
        return this.AreaOfLiving;
    }

    /**
     * method that sets the value of the wingspan
     * @param new_AreaOfLiving
     * @return if it succeed or failed
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
     * @return the attributes as a string
     */
    public String toString()
    {
        return "AreaOfLiving: " + this.AreaOfLiving  + ", " + super.toString();
    }

    /**
     * prints the the name of the class and the sound of the animal
     */
    public void makeSound(){
        System.out.println("Alligator "  + super.get_name() + " said: Roar");
    }
}

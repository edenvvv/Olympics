package animals;

import Olympics.Medal;
import graphics.CompetitionPanel;
import mobility.Point;

/**
 * Class that describes an Whale attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Whale extends WaterAnimal{
    private String foodType;

    /**
     * Default constructor (with proper values)
     */
    public Whale(CompetitionPanel pan){
        super(pan);
        this.foodType = "plankton";
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
     * @param foodType
     */

    public Whale(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, String foodType){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        if(foodType.length() > 0) {
            this.foodType = foodType;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.foodType = "plankton";
        }

    }


    /**
     * Get the food type of the whale
     * @return food type
     */
    public String get_foodType(){
        return this.foodType;
    }

    /**
     * Set the food type of the whale
     * @param new_foodType
     * @return true if succeed, false if isn't
     */
    public boolean set_foodType(String new_foodType){
        if(new_foodType.length() > 0){
            this.foodType = new_foodType;
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
        return "foodType: " + this.foodType  + ", " + super.toString();
    }

    /**
     * prints the sound of the animal
     */
    protected String getsound()
    {
        return "Splash";
    }
}

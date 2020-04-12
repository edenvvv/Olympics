package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Class that describes an Dolphin attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Dolphin extends WaterAnimal {
    public enum WaterType {Sea, Sweet};
    private WaterType Water_Type;

    /**
     * Default constructor (with proper values)
     */
    public Dolphin(){
        super();
        this.Water_Type = WaterType.Sea;
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
     * @param Water_Type
     */
    public Dolphin(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, WaterType Water_Type){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        this.Water_Type = Water_Type;
    }


    /**
     * Get the water type of the dolphin
     * @return Water type (Sea or Sweet-water)
     */
    public WaterType get_Water_Type(){
        return this.Water_Type;
    }

    /**
     * Set the gender of the dolphin
     * @param new_Water_Type
     * @return true if succeed, false if isn't
     */
    public boolean set_gender(WaterType new_Water_Type){
        this.Water_Type = new_Water_Type;
        return true;
    }

    /**
     * Returns the attributes as a string
     * @return string with the attributes
     */
    public String toString()
    {
        return "WaterType: " + this.Water_Type  + ", " + super.toString();
    }

    /**
     * prints the the name of the class and the sound of the animal
     */
    public void makeSound(){
        System.out.println("Dolphin "  + super.get_name() + " said: Click-click");
    }
}

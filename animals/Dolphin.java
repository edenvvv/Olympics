package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
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
        this.sound = "Click-click";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Dolphin(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, WaterType Water_Type){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        this.Water_Type = Water_Type;
        this.sound = "Click-click";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "WaterType: " + this.Water_Type  + ", " + super.toString();
    }
}

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public class Pigeon extends AirAnimal {
    private String family;

    /**
     * Default constructor (with proper values)
     */
    public Pigeon(){
        super();
        this.family = "poultry";
        this.sound = "Arr-rar-rar-rar-raah";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Pigeon(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double wingspan, String family){
        super(name, my_genders, weight, speed, medals, position,wingspan);
        this.family = family;
        this.sound = "Arr-rar-rar-rar-raah";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "family: " + this.family  + ", " + super.toString();
    }
}

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
        if(family.length() > 0) {
            this.family = family;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.family = "poultry";
        }
        this.sound = "Arr-rar-rar-rar-raah";
    }

    /**
     *
     */
    public String get_family(){
        return this.family;
    }

    /**
     *
     */
    public boolean set_family(String new_family){
        if(new_family.length() > 0){
            this.family = new_family;
            return true;
        }
        return false;
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "family: " + this.family  + ", " + super.toString();
    }
}

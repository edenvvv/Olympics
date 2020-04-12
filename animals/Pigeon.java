package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Pigeon attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Pigeon extends AirAnimal {
    private String family;

    /**
     * Default constructor (with proper values)
     */
    public Pigeon(){
        super();
        this.family = "poultry";
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     * @param wingspan
     * @param family
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
    }

    /**
     * Get the family of the pigeon
     * @return family type
     */
    public String get_family(){
        return this.family;
    }

    /**
     * Set the family og the pigeon
     * @param new_family
     * @return true if succeed, false if isn't
     */
    public boolean set_family(String new_family){
        if(new_family.length() > 0){
            this.family = new_family;
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
        return "family: " + this.family  + ", " + super.toString();
    }

    /**
     * prints the the name of the class and the sound of the animal
     */
    public void makeSound(){
        System.out.println("Pigeon "  + super.get_name() + " said: Arr-rar-rar-rar-raah");
    }
}

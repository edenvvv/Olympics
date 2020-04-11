package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Dog attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Dog extends TerrestrialAnimals{
    private String breed;

    /**
     * Default constructor (with proper values)
     */
    public Dog(){
        super();
        this.breed = "None";
        super.set_sound("Woof Woof");
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     * @param noLegs
     * @param breed
     */
    public Dog(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, String breed){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        if(breed.length() > 0){
            this.breed = breed;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.breed = "None";
        }
        super.set_sound("Woof Woof");
    }


    /**
     * get the breed of the dog
     * @return breed
     */
    public String get_breed(){
        return this.breed;
    }

    /**
     * Set the dog's breed
     * @param new_breed
     * @return true if succeed, false if isn't
     */
    public boolean set_breed(String new_breed){
        if(new_breed.length() > 0){
            this.breed = new_breed;
            return true;
        }
        return false;
    }

    /**
     * Returns the attributes as a string
     * @return stirng with the attributes
     */
    public String toString()
    {
        return "breed: " + this.breed + ", " + super.toString() ;
    }

}

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Cat attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Cat extends TerrestrialAnimals{
    private boolean Castrated;

    /**
     * Default constructor (with proper values)
     */
    public Cat(){
        super();
        this.Castrated = true;

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
     * @param Castrated
     */
    public Cat(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, boolean Castrated){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        this.Castrated = Castrated;
    }


    /**
     * Get if the cat is castrated
     * @return true if he is' false if he isn't
     */
    public boolean get_Castrated(){
        return this.Castrated;
    }

    /**
     * set if the cat is castrated
     * @param Castrated
     * @return it succeed
     */
    public boolean set_Castrated(boolean Castrated){
        this.Castrated = Castrated;
        return true;
    }

    /**
     * Returns the attributes as a string
     * @return string with attributes
     */
    public String toString()
    {
        return "castrated: " + this.Castrated  + ", " + super.toString();
    }

    /**
     * prints the the name of the class and the sound of the animal
     */
    public void makeSound(){
        System.out.println("Cat "  + super.get_name() + " said: Meow");
    }
}

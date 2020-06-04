package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Class that describes an Alligator attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Alligator extends WaterAnimal implements IReptile{
    private Iterrestrial terrestrial;
    private String AreaOfLiving;

    /**
     * Default constructor (with proper values)
     */
    public Alligator(){
        super();
        this.terrestrial = new TerrestrialAnimals() {
            protected String getsound() {
                return "Roar";
            }
        };
        if(super.getSpeed() > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
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
    public Alligator(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept, String AreaOfLiving, int noLegs){
        super(name, my_genders, weight, speed, medals, position,diveDept);
        if(speed > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
        if(AreaOfLiving.length() > 0) {
            this.AreaOfLiving = AreaOfLiving;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.AreaOfLiving = "Lake";
        }
        this.terrestrial = new TerrestrialAnimals(name, my_genders, weight, speed, medals, position,noLegs) {
            protected String getsound() {
                return "Roar";
            }
        };
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
        return "AreaOfLiving: " + this.AreaOfLiving  + ", " + super.toString() + ", " + "number of Legs: " + terrestrial.get_num_of_legs();
    }

    /**
     * prints the sound of the animal
     */
    protected String getsound()
    {
        return "Roar";
    }

    public void speedUp(int speed){
        double new_speed = super.getSpeed() + speed;
        if (new_speed > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
        else {
            super.set_speed(new_speed);
        }
    }

    public Iterrestrial set_type_terrestrial() {
        Iterrestrial temp =  new TerrestrialAnimals() {
            protected String getsound() {
                return "Roar";
            }
        };
        return temp;
    }
}

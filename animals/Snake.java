package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Snake attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Snake extends TerrestrialAnimals implements IReptile {
    public enum Poisonous {}; //
    private double length;

    /**
     * Default constructor (with proper values)
     */
    public Snake(){
        super();
        this.length = 2.5;
        super.set_sound("ssssssss");
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
     * @param length
     */
    public Snake(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, double length){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        if(speed > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
        if(length > 0) {
            this.length = length;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.length = 2.5;
        }
        super.set_sound("ssssssss");
    }

    /**
     * Get the length of the snake
     * @return length
     */
    public double get_length(){
        return this.length;
    }

    /**
     * Set the length of the snake
     * @param new_length
     * @return true if succeed, false if isn't
     */
    public boolean set_length(double new_length){
        if(new_length > 0){
            this.length = new_length;
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
        return "length: " + this.length  + ", " + super.toString();
    }

    /**
     * Adding speed to the current speed of the snake, not more than the maximum
     * @param speed
     */
    public void speedUp(int speed) {
        double new_speed = super.get_speed() + speed;
        if (new_speed > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
        else {
            super.set_speed(new_speed);
        }
    }
}

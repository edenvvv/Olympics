package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
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
        this.sound = "ssssssss";
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public Snake(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, int noLegs, double length){
        super(name, my_genders, weight, speed, medals, position,noLegs);
        if(speed > MAX_SPEED){
            super.set_speed(MAX_SPEED);
        }
        this.length = length;
        this.sound = "ssssssss";
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "length: " + this.length  + ", " + super.toString();
    }

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

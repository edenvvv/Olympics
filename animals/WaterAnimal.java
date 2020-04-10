package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 */
public abstract class WaterAnimal extends Animal {
    static final int MAX_DIVE = -800;
    private double diveDept;

    /**
     * Default constructor (with proper values)
     */
    public WaterAnimal(){
        super();
        super.set_position(new Point(50,0));
        this.diveDept = 0.0;
    }

    /**
     * constructor that initializes according to the attributes it received
     */
    public WaterAnimal(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double diveDept){
        super(name, my_genders, weight, speed, medals, position);
        if(diveDept > 0){
            diveDept = -diveDept;
        }
        if(diveDept > MAX_DIVE) {
            this.diveDept = diveDept;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value (MAX = -800)");
            this.diveDept = MAX_DIVE;
        }
    }


    /**
     *
     */
    public double get_diveDept(){
        return this.diveDept;
    }

    /**
     *
     */
    public boolean set_wingspan(double diveDept){
        if(diveDept > 0){
            diveDept = -diveDept;
        }
        if(diveDept > MAX_DIVE) {
            this.diveDept = diveDept;
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void Dive(double dive){
        if(dive > 0){
            dive = -dive;
        }
        double new_dive = this.diveDept + dive;
        if(new_dive < MAX_DIVE) {
            this.diveDept = MAX_DIVE;
        }
        else {
            this.diveDept = new_dive;
        }
    }

    /**
     * Returns the attributes as a string
     */
    public String toString()
    {
        return "diveDept: " + this.diveDept + super.toString();
    }
}

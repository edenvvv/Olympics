package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Water Animal Animals attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public abstract class WaterAnimal extends Animal {
    static final int MAX_DIVE = -800;
    private double diveDept;

    /**
     * Default constructor (with proper values)
     */
    public WaterAnimal(){
        super();
        super.setLocation(new Point(65,55));
        this.diveDept = 0.0;
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
     * Get the diving dept of the water animal
     * @return dept
     */
    public double get_diveDept(){
        return this.diveDept;
    }

    /**
     * Set the wing span of the water animal
     * @param diveDept
     * @return true if succeed, false if isn't
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
     * order the animal to dive not if tis greater than the Maximum dive limit
     * @param dive
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
     * returns the attributes as a string
     * @return string with the attributes
     */
    public String toString()
    {
        return "diveDept: " + this.diveDept + super.toString();
    }
}

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * Class that describes an Air-Animal attributes
 *  @author eden dadon id:207279183
 *  @author Eliran Dagan id: 208061580
 */
public abstract class AirAnimal extends Animal {
    private double wingspan;

    /**
     * Default constructor (with proper values)
     */
    public AirAnimal(){
        super();
        super.setLocation(new Point(0,110));
        this.wingspan = 0.8;

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
     */
    public AirAnimal(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position, double wingspan){
        super(name, my_genders, weight, speed, medals, position);
        if(wingspan > 0) {
            this.wingspan = wingspan;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.wingspan = 0.8;
        }

    }

    /**
     * method that returns the value of the wingspan
     * @return the wingspan
     */
    public double get_wingspan(){
        return this.wingspan;
    }


    /**
     * method that sets the value of the wingspan
     * @param new_wingspan
     * @return if it succeed or failed
     */
    public boolean set_wingspan(double new_wingspan){
        if(new_wingspan > 0){
            this.wingspan = new_wingspan;
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
        return "wingspan: " + this.wingspan + super.toString();
    }
}

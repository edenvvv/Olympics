package animals;
import mobility.Mobile;
import mobility.Point;
import Olympics.Medal;

/**
 * Class that describes an Animal attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public abstract class Animal extends Mobile{
    public enum gender {Male, Female, Hermaphrodite}
    private gender my_genders;
    private String name;
    private double weight;
    private double speed;
    private Medal[] medals;
    private Point position = new Point();

    protected abstract String getsound();


    /**
     * Default constructor (with proper values)
     */
    public Animal(){
        super();
        this.name = "brownie";
        this.my_genders = gender.Male;
        this.weight = 36.5;
        this.speed = 1.2;
        this.medals = new Medal[] {new Medal(Medal.types.silver, "BLOB", 2000), new Medal(Medal.types.silver, "Blob", 2015)};
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param name
     * @param my_genders
     * @param weight
     * @param speed
     * @param medals
     * @param position
     */
    public Animal(String name, gender my_genders, double weight, double speed, Medal[] medals, Point position){
        super();
        if(name.length() > 0){
            this.name = name;
        }
        else {
            System.out.println("You have entered incorrect value. It's okay, we provided a default value");
            this.name = "brownie";
        }
        this.my_genders = my_genders;
        this.weight = weight;
        this.speed = speed;
        this.medals = medals;
        set_position(position);
    }

    /**
     * Return the gender of the animal
     * @return gender
     */
    public gender get_gender(){
        return this.my_genders;
    }

    /**
     * Set the gender of the animal
     * @param new_genders
     * @return if it succeed or failed
     */
    public boolean set_gender(gender new_genders){
        this.my_genders = new_genders;
        return true;
    }

    /**
     * Get the name of the animal
     * @return name
     */
    public String get_name(){
        return this.name;
    }

    /**
     * Set the name of the animal
     * @param new_name
     * @return if it succeed or failed
     */
    public boolean set_name(String new_name){
        if(new_name.length() > 0){
            this.name = new_name;
            return true;
        }
        return false;
    }

    /**
     * Get the weight of the animal
     * @return weight
     */
    public double get_weight(){
        return this.weight;
    }

    /**
     * Set the weight of the animal
     * @param new_weight
     * @return if it succeed or failed
     */
    public boolean set_weight(double new_weight){
        if(new_weight > 0){
            this.weight = new_weight;
            return true;
        }
        return false;
    }

    /**
     * protected: set the position of the animal
     * @param nuw_Point
     * @return if it succeed or failed
     */
    protected boolean set_position(Point nuw_Point){
        super.setLocation(nuw_Point);
        this.position = super.getLocation();
        return true;
    }

    /**
     * Private: get the medals of the aninal as string
     * @return string of medals
     */
    private String printMedals()
    {
        String medals = "";
        for(Medal i : this.medals)
        {
            medals += i;
            medals += ", ";
        }
        return medals;
    }

    /**
     * Returns the attributes as a string
     * @return the attributes as a string
     */
    public String toString()
    {
        return " Name: " + this.name + ", Gender: " + this.my_genders + ", Weight: " + this.weight + ", Speed: " +
                this.speed + ", Medals details: " + printMedals() + "Position: " + this.position;
    }



    /**
     * protected: set the speed of the animal
     * @param new_speed
     * @return if it succeed or failed
     */
    protected boolean set_speed(double new_speed){
        if(new_speed > 0){
            this.speed = new_speed;
            return true;
        }
        return false;
    }

    /**
     * Protected: get the speed of the animal
     * @return speed of animal
     */
    protected double get_speed(){
        return this.speed;
    }

    /**
     * show the sound of the animal
     */
    public void makeSound()
    {
        System.out.println(this.getClass().getName() + " " + this.get_name() +  " said " + this.getsound());
    }

}

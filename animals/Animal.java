package animals;
import mobility.Mobile;
import mobility.Point;
import Olympics.Medal;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 * Represents Animal attributes
 */
public abstract class Animal extends Mobile{
    public enum gender {Male, Female, Hermaphrodite}
    private gender my_genders;
    private String name;
    private double weight;
    private double speed;
    private Medal[] medals;
    private Point position = new Point();
    protected String sound; //

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
     *
     */
    public gender get_gender(){
        return this.my_genders;
    }

    /**
     *
     */
    public boolean set_gender(gender new_genders){
        this.my_genders = new_genders;
        return true;
    }

    /**
     *
     */
    public String get_name(){
        return this.name;
    }

    /**
     *
     */
    public boolean set_name(String new_name){
        if(new_name.length() > 0){
            this.name = new_name;
            return true;
        }
        return false;
    }

    /**
     *
     */
    public double get_weight(){
        return this.weight;
    }

    /**
     *
     */
    public boolean set_weight(double new_weight){
        if(new_weight > 0){
            this.weight = new_weight;
            return true;
        }
        return false;
    }

    /**
     *
     */
    protected boolean set_position(Point nuw_Point){
        super.setLocation(nuw_Point);
        this.position = super.getLocation();
        return true;
    }

    /**
     *
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
     */
    public String toString()
    {
        return " Name: " + this.name + ", Gender: " + this.my_genders + ", Weight: " + this.weight + ", Speed: " +
                this.speed + ", Medals details: " + printMedals() + "Position: " + this.position;
    }


    /**
     *
     */
    public void makeSound(){
        System.out.println(this.getClass().getName() + " " + this.name + " said " + this.sound);
    }

    /**
     *
     */
    protected boolean set_speed(double new_speed){
        if(new_speed > 0){
            this.speed = new_speed;
            return true;
        }
        return false;
    }

    /**
     *
     */
    protected double get_speed(){
        return this.speed;
    }
}

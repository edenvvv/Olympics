package animals;

import Olympics.Medal;
import graphics.CompetitionPanel;
import graphics.IAnimal;
import graphics.IDrawable;

import mobility.ILocatable;
import mobility.Mobile;
import mobility.Point;




import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that describes an Animal attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public abstract class Animal extends Mobile implements IAnimal, ILocatable, IDrawable {
    /**
    "eat" method that moves the animal on the board with the parameter energy from the user
     @param energy
     */
    public boolean eat(int energy) {
        int tempEnergy = this.current_energy + energy;

        if(tempEnergy > this.maxEnergy) {
            this.current_energy = this.maxEnergy;
        }
        else {
            this.current_energy += energy;
        }
        if(this.current_energy > 0 && this.current_energy > this.energyPerMeter) {
            super.setLocation(new Point((int) (super.getLocation().getX()+getSpeed()),super.getLocation().getY()));
            this.current_energy -= this.energyPerMeter;
            ++distance;
        }
        return true;
    }

    /**
     * method that load images from package to show the selected animals
     * @param nm
     * @throws IOException
     */
    public void loadImages(String nm) throws IOException {
        img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm));
        img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm));
        img3 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm));
        img4 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm));
    }


    /**
     * method that shows the GUI part of the program, the board and the chosen animals
     * @param g
     */
    public void drawObject(Graphics g) {
        if(orien==Orientation.EAST) // animal move to the east side
            g.drawImage(img1, super.getLocation().getX(), super.getLocation().getY(), size, size,
                    pan);
        else if(orien==Orientation.SOUTH) // animal move to the south side
            g.drawImage(img2, super.getLocation().getX(), super.getLocation().getY(), size, size,
                    pan);
        else if(orien==Orientation.WEST) // animal move to the west side
            g.drawImage(img3, super.getLocation().getX(), super.getLocation().getY(), size, size,
                    pan);
        else if(orien==Orientation.NORTH) // animal move to the north side
            g.drawImage(img4, super.getLocation().getX()-size/2, super.getLocation().getY(), size,
                    size, pan);


    }



    public enum Orientation {EAST, SOUTH, WEST,NORTH}
    protected int size;
    protected Orientation orien;
    protected int maxEnergy;
    protected int energyPerMeter;
    protected int current_energy;
    protected CompetitionPanel pan;
    protected BufferedImage img1, img2, img3, img4;
    private double distance;



    public enum gender {Male, Female, Hermaphrodite}
    private gender my_genders;
    private String name;
    private double weight;
    private double speed;
    private Medal[] medals;

    protected abstract String getsound();

    /**
     * Default constructor (with proper values)
     */
    public Animal(){
        super();
        this.name = "brownie";
        this.my_genders = gender.Male;
        this.weight = 36.5;
        this.speed = Math.random() * 15;
        this.medals = new Medal[] {new Medal(Medal.types.silver, "BLOB", 2000),
                new Medal(Medal.types.silver, "Blob", 2015)};



        this.size = 65;
        this.orien = Orientation.EAST;
        this.maxEnergy = 60;
        this.current_energy = 30;
        this.energyPerMeter = 4;
        this.distance = 0;
        this.pan = new CompetitionPanel();

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
        super(position);
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

        this.size = 65;
        this.orien = Orientation.EAST;
        this.maxEnergy = 60;
        this.current_energy = 30;
        this.energyPerMeter = 4;
        this.distance = 0;
        this.pan = new CompetitionPanel();
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
     * @return distance
     */
    public double get_distance(){
        return this.distance;
    }


    /**
     * Get the weight of the animal
     * @return distance
     */
    public float get_current_energy(){
        return this.current_energy;
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
                this.speed + ", Medals details: " + printMedals() + "Position: " + super.getLocation();
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
    public double getSpeed(){
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

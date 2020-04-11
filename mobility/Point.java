package mobility;

/**
 * Class that describes an Point attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Point {
    private int x;
    private int y;

    /**
     * Default constructor (with proper values)
     */
    public Point(){
        this.x = 0;
        this.y = 0;
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param x
     * @param y
     */
    public Point(int x ,int y){
        if ((x < 0) || (y < 0)){
            System.out.println("Invalid value is different from dipole value");
            this.x = 0;
            this.y = 0;
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the attributes as a string
     * @return string with the attributes
     */
    public String toString(){
        return "x: " + this.x + " y: " + this.y;
    }

    /**
     * get X value
     * @return x
     */
    public int getX(){
        return this.x;
    }

    /**
     * get Y value
     * @return y
     */
    public int getY(){
        return this.y;
    }

    /**
     * set X value
     * @param x
     * @return true if succeed, false if isn't
     */
    public boolean setX(int x){
        if (x < 0){
            return false;
        }
        this.x = x ;
        return true;
    }

    /**
     * set Y value
     * @param y
     * @return true if succeed, false if isn't
     */
    public boolean setY(int y){
        if (y < 0){
            return false;
        }
        this.y = y ;
        return true;
    }
}

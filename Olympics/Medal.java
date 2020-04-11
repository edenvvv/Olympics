package Olympics;

/**
 * Class that describes an Point attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class Medal {
    public enum types {bronze, silver, gold}
    private types type;
    private String tournament;
    private int year;

    /**
     * Default constructor (with proper values)
     */
    public Medal() {
        this.type = types.bronze;
        this.tournament = "Tokyo";
        this.year = 2020;
    }

    /**
     * constructor that initializes according to the attributes it received
     * @param type
     * @param tournament
     * @param year
     */
    public Medal(types type, String tournament, int year) {
        if (year < 0){
            System.out.println("Invalid value is different from dipole value");
            this.year = 2020;
        }
        this.type = type;
        this.tournament = tournament;
        this.year = year;
    }

    /**
     * Returns the attributes as a string
     * @return string with the attributes
     */
    public String toString(){
        return "type: " + this.type + " tournament: " + this.tournament + " year: " +this.year;
    }


}

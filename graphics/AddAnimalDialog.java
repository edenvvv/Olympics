package graphics;

import animals.Animal;
import animals.*;

import javax.swing.*;

import java.util.Vector;

import static graphics.CompetitionPanel.pop_up;


public class AddAnimalDialog extends JDialog {

    private int choice;
    private Vector<Animal> vector;

    public AddAnimalDialog(Vector<Animal> vector, int choice){
        this.choice = choice;
        this.vector = vector;
    }

    boolean choose_animal_type() throws Exception {
        if (choice == -1){
            JOptionPane.showMessageDialog(new JDialog(), "The type of animal should match the type of animal selected in the competition",
                    "Error",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        Object[] options = {"Air", "Water", "Terrestrial"};
        int competition_type = pop_up(options,options.length-1,"What kind of competition?", "CompetitionDialog");
        if(competition_type == choice){
            return true;
        }
        throw new Exception();

    }

    public String choose_animal() throws Exception {
        int competition_type = -1;
        if(choose_animal_type()){
            if(this.choice == 0){
                Object[] options = {"Eagle", "Pigeon"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == 0){
                    this.vector.add(new Eagle());
                }
                else if(competition_type == 1){
                    this.vector.add(new Pigeon());
                }
                return "Air";
            }
            else if(this.choice == 1){
                Object[] options = {"Whale", "Alligator", "Dolphin"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == 0){
                    this.vector.add(new Whale());
                }
                else if(competition_type == 1){
                    this.vector.add(new Alligator());
                }
                else if(competition_type == 2){
                    this.vector.add(new Dolphin());
                }
                return "Water";
            }
            else if(this.choice == 2){
                Object[] options = {"Dog", "Cat", "Alligator", "Snake"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == 0){
                    this.vector.add(new Dog());
                }
                else if(competition_type == 1){
                    this.vector.add(new Cat());
                }
                else if(competition_type == 2){
                    this.vector.add(new Alligator());
                }
                else if(competition_type == 3){
                    this.vector.add(new Snake());
                }
                return "Terrestrial";
            }
        }
        return null;
    }
}

package graphics;

import animals.Animal;
import animals.*;

import javax.swing.*;

import java.util.Vector;

import static graphics.CompetitionPanel.exit_frame;
import static graphics.CompetitionPanel.pop_up;


public class AddAnimalDialog extends JDialog {

    private int choice;
    private Vector<Animal> vector;

    public AddAnimalDialog(Vector<Animal> vector, int choice){
        this.choice = choice;
        this.vector = vector;
    }

    boolean choose_animal_type(JFrame my_frame) throws Exception {
        if (choice == -1){
            JOptionPane.showMessageDialog(new JDialog(), "The type of animal should match the type of animal selected in the competition",
                    "Error",JOptionPane.ERROR_MESSAGE);
            exit_frame(my_frame);
        }
        Object[] options = {"Air", "Water", "Terrestrial"};
        int competition_type = pop_up(options,options.length-1,"What kind of competition?", "CompetitionDialog");
        if(competition_type == -1){
            return false;
        }
        if(competition_type == choice){
            return true;
        }
        throw new Exception();

    }

    public String choose_animal(CompetitionPanel pan, JFrame my_frame) throws Exception {
        int competition_type = -1;
        if(choose_animal_type(my_frame)){
            if(this.choice == 0){
                Object[] options = {"Eagle", "Pigeon"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == -1){
                    return " ";
                }
                if(competition_type == 0){
                    this.vector.add(new Eagle(pan));
                    vector.lastElement().loadImages("eagle1.png");
                }
                else if(competition_type == 1){
                    this.vector.add(new Pigeon(pan));
                    vector.lastElement().loadImages("pigeon.png");
                }
                return "Air";
            }
            else if(this.choice == 1){
                Object[] options = {"Whale", "Alligator", "Dolphin"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == -1){
                    return " ";
                }
                if(competition_type == 0){
                    this.vector.add(new Whale(pan));
                    vector.lastElement().loadImages("whaleE.png");
                }
                else if(competition_type == 1){
                    this.vector.add(new Alligator(pan));
                    vector.lastElement().loadImages("alligator2E.png");
                }
                else if(competition_type == 2){
                    this.vector.add(new Dolphin(pan));
                    vector.lastElement().loadImages("dolphin1E.png");
                }
                return "Water";
            }
            else if(this.choice == 2){
                Object[] options = {"Dog", "Cat", "Alligator", "Snake"};
                competition_type = pop_up(options,options.length-1,"What animal do you want?", "CompetitionDialog");
                if(competition_type == -1){
                    return " ";
                }
                if(competition_type == 0){
                    this.vector.add(new Dog(pan));
                    vector.lastElement().loadImages("dog1E.png");
                }
                else if(competition_type == 1){
                    this.vector.add(new Cat(pan));
                    vector.lastElement().loadImages("cat1E.png");
                }
                else if(competition_type == 2){
                    Alligator temp= new Alligator(pan);
                    this.vector.add(temp.set_type_terrestrial());
                    vector.lastElement().loadImages("alligator2E.png");
                }
                else if(competition_type == 3){
                    this.vector.add(new Snake(pan));
                    vector.lastElement().loadImages("snake1E.png");
                }
                return "Terrestrial";
            }
        }
        return " ";
    }
}

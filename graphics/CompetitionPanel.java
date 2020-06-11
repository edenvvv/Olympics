package graphics;

import animals.Animal;
import mobility.Point;
import threads.CourierTournament;
import threads.RegularTournament;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static animals.AnimalThread.print_mas;

/**
 * Class that describes an competition attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class CompetitionPanel extends JPanel implements ActionListener {

    private BufferedImage img = null;
    private BufferedImage animal_img = null;
    private String choose;
    private int Tournament_choose;
    private Animal[][] regular_setup_arr;
    private int setup_counter;
    private final int setup_max_size = 30;

    private RegularTournament regular_tournament;
    private CourierTournament courier_tournament;

    public static Boolean start_flag = false;



    private JPanel buttonPanel;
    private int competition_type = -1;
    private Vector<Animal> vec= new Vector<>();

    /**
     * Default Ctor, for the competition panel (GUI patr)
     */
    public CompetitionPanel()
    {
        super(new BorderLayout());

        try
        {
            img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "competitionBackground.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JDialog(), "Cannot open background file");
            System.exit(1);
        }

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());

        JButton competition_button = new JButton("Competition");
        JButton add_animal_button = new JButton("Add Animal");
        JButton clear_button = new JButton("Clear");
        JButton eat_button = new JButton("Eat");
        JButton info_button = new JButton("Info");
        JButton exit = new JButton("Exit");

        competition_button.addActionListener(this);
        add_animal_button.addActionListener(this);
        clear_button.addActionListener(this);
        eat_button.addActionListener(this);
        info_button.addActionListener(this);
        exit.addActionListener(this);

        add(this.buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(competition_button);
        buttonPanel.add(add_animal_button);
        buttonPanel.add(clear_button);
        buttonPanel.add(eat_button);
        buttonPanel.add(info_button);
        buttonPanel.add(exit);

        setup_counter = 0;
        regular_setup_arr = new Animal[setup_max_size][];
        for(int i=0; i < regular_setup_arr.length; ++i){
            regular_setup_arr[i] = new Animal[1];
        }

    }

    /**
     * method that covers the panel with selected draws and pictures, uses the the chosen animals method "drawObject"
     * to show the selected animals
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        if(!vec.isEmpty()) {
            for (Animal animal : vec) {
                animal.drawObject(g);
            }
            //vec.lastElement().drawObject(g);
        }
    }

    /**
     * method gives energy to all the animals that selected by the user
     * @param num
     */
    public void eat_all(int num){
        for (Animal animal : vec) {
            animal.eat(num);
        }
    }

    /**
     * GUI method for pop-up message to user when he select the competition section
     * @param obg
     * @param size
     * @param mas
     * @param title
     * @return
     */
    public static int pop_up(Object[] obg,int size,String mas,String title){
        return JOptionPane.showOptionDialog(new JDialog(), "What kind of competition would you like?",
                "CompetitionDialog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                obg,
                obg[size]);
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        String choose_button = e.getActionCommand();

        if(choose_button.equals("Exit"))
        {
            System.exit(0);
        }

        if(choose_button.equals("Competition"))
        {
            //vec.clear();
            Object[] Tournament = {"Regular Tournament", "Courier Tournament"};
            this.Tournament_choose = pop_up(Tournament,Tournament.length-1,"What kind of Tournament?", "CompetitionDialog");
            if(Tournament_choose == -1){
                return;
            }
            if(this.Tournament_choose == 0){
                regular_tournament = new RegularTournament(regular_setup_arr);
                regular_tournament.init_threads();

            }
            else if(this.Tournament_choose == 1){
                courier_tournament = new CourierTournament();
            }


            Object[] options = {"Air", "Water", "Terrestrial"};
            this.competition_type = pop_up(options,options.length-1,"What kind of competition?", "CompetitionDialog");
        }

        if(choose_button.equals("Add Animal"))
        {
            try {
                AddAnimalDialog animal = new AddAnimalDialog(vec, this.competition_type);
                if(!vec.isEmpty()) {
                    if((choose.equals("Air")) && (vec.size() >= 3)){
                        JOptionPane.showMessageDialog(new JDialog(), "There is no room for Air animals",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(choose.equals("Air")){
                        if (vec.size() == 1){
                            vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(),vec.lastElement().getLocation().getY()+111));
                        }
                        if (vec.size() == 2){
                            vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(),vec.lastElement().getLocation().getY()+227));
                        }
                    }
                    else if((choose.equals("Water")) && (vec.size() >= 4)){
                        JOptionPane.showMessageDialog(new JDialog(), "There is no room for Water animals",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(choose.equals("Water")) {
                        if (vec.size() == 1) {
                            vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(), vec.lastElement().getLocation().getY() + 111));
                        }
                        if (vec.size() == 2) {
                            vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(), vec.lastElement().getLocation().getY() + 227));
                        }
                        if (vec.size() == 3) {
                            vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(), vec.lastElement().getLocation().getY() + 343));
                        }
                    }
                    else if(choose.equals("Terrestrial") && (vec.size() >= 2)){
                        JOptionPane.showMessageDialog(new JDialog(), "There is no room for Terrestrial animals",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(choose.equals("Terrestrial")) {
                        vec.lastElement().setLocation(new Point(vec.lastElement().getLocation().getX(), vec.lastElement().getLocation().getY() + 111));
                    }
                }
                choose = animal.choose_animal(this);
                if (choose.equals(" ")){
                    return;
                }
                regular_setup_arr[setup_counter][0] = vec.lastElement();
                regular_tournament.set_threads(regular_setup_arr, vec.lastElement(), setup_counter);
                ++setup_counter;
                repaint();
                //System.out.println(vec.toString());
            }
            catch (Exception x){
                JOptionPane.showMessageDialog(new JDialog(), "The type of animal should match the type of animal selected in the competition " + x.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        if(choose_button.equals("Clear"))
        {
            vec.clear();
            regular_tournament.stop_threads();
            repaint();
        }

        if(choose_button.equals("Eat"))
        {
            Object[] options = {"1","2", "5", "10"};
            int add_energy = pop_up(options, options.length - 1, "How much energy you want to add?", "Add Energy");

            eat_one(add_energy);

        }
        else if (choose_button.equals("Info")) {
            JFrame table_frame = new JFrame("Info");
            String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
            Animal animal;

            int index_of;
            String[][] data = new String[this.vec.size()][columnNames.length];
            for (int i = 0; i < this.vec.size(); i++)
            {
                animal = vec.get(i);
                if (animal != null)
                {
                    data[i][0] = animal.get_name();
                    data[i][1] = animal.getClass().getSuperclass().toString().substring(14);
                    index_of = animal.getClass().getName().indexOf("$");
                    if(index_of == -1){
                        data[i][2] = animal.getClass().getName().substring(8);
                    }
                    else {
                        data[i][2] = animal.getClass().getName().substring(8,index_of);
                    }
                    data[i][3] = String.valueOf(animal.getSpeed());
                    data[i][4] = String.valueOf(animal.get_current_energy());
                    data[i][5] = String.valueOf(animal.getLocation().getX());
                    data[i][6] = String.valueOf(animal.get_current_energy());
                }
            }

            final JTable jt=new JTable(data,columnNames);
            jt.setCellSelectionEnabled(true);
            ListSelectionModel select= jt.getSelectionModel();
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane sp=new JScrollPane(jt);
            table_frame.add(sp);
            table_frame.setSize(3000, 88 + vec.size()*45);
            table_frame.setVisible(true);
            jt.setEnabled(false);
            repaint();
        }
    }

    public void repan(){
        repaint();
    }

    public void eat_one(int i){
        if(i == 0)
        {
            eat_all(1);
        }
        else if(i == 1)
        {
            eat_all(2);
        }
        else if(i == 2)
        {
            eat_all(5);
        }
        else if(i == 3)
        {
            eat_all(10);
        }
    }
}

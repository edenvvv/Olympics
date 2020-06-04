package graphics;

import animals.Animal;
import animals.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class CompetitionPanel extends JPanel implements ActionListener {

    private BufferedImage img = null;
    private BufferedImage animal_img = null;
    private int x = 712 ;
    private int y = 0;



    private JPanel buttonPanel;
    private int competition_type = -1;
    private Vector<Animal> vec= new Vector<>();

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
    }


    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        if(!vec.isEmpty())
            vec.lastElement().drawObject(g);

    }


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
            vec.clear();
            Object[] options = {"Air", "Water", "Terrestrial"};
            this.competition_type = pop_up(options,options.length-1,"What kind of competition?", "CompetitionDialog");
        }

        if(choose_button.equals("Add Animal"))
        {
            try {
                AddAnimalDialog animal = new AddAnimalDialog(vec, this.competition_type);
                animal.choose_animal();
                repaint();
                System.out.println(vec.toString());
            }
            catch (Exception x){
                JOptionPane.showMessageDialog(new JDialog(), "The type of animal should match the type of animal selected in the competition",
                    "Error",JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        if(choose_button.equals("Clear"))
        {
            vec.clear();
            repaint();
        }

        if(choose_button.equals("Eat"))
        {
            Object[] options = {"1","2", "5", "10"};
            int add_energy = pop_up(options, options.length - 1, "How much energy you want to add?", "Add Energy");

            if(add_energy == 0)
            {
                vec.lastElement().eat(1);
                repaint();
            }
            else if(add_energy == 1)
            {
                vec.lastElement().eat(2);
                repaint();
            }
            else if(add_energy == 2)
            {
                vec.lastElement().eat(5);
                repaint();
            }
            else if(add_energy == 3)
            {
                vec.lastElement().eat(10);
                repaint();
            }
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
                    data[i][5] = String.valueOf(animal.get_distance());
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
}

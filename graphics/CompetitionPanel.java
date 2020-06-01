package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompetitionPanel extends JPanel implements ActionListener {

    private BufferedImage img = null;
    private JPanel buttonPanel;

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

    }
}

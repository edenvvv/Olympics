package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionFrame extends JFrame implements ActionListener
{
    private JMenu jmenuFile, jmenuHelp;
    private JMenuItem jmenuitemExit, jmenuitemAbout;
    CompetitionPanel pan;


    public CompetitionFrame ()
    {
        super("Competition");
        setPreferredSize(new Dimension(800, 600));
        this.jmenuFile = new JMenu("File");
        this.jmenuitemExit = new JMenuItem("Exit");
        this.jmenuFile.add(jmenuitemExit);
        this.jmenuHelp = new JMenu("Help");
        this.jmenuitemAbout = new JMenuItem("Help");
        this.jmenuHelp.add(this.jmenuitemAbout);
        JMenuBar mb = new JMenuBar();
        mb.add(this.jmenuFile);
        mb.add(this.jmenuHelp);
        setJMenuBar(mb);

        this.pan = new CompetitionPanel();
        this.add(pan);

        jmenuitemAbout.addActionListener(this);
        jmenuitemExit.addActionListener(this);

    }

    public static void main(String args[])
    {
        CompetitionFrame com_frame = new CompetitionFrame();
        com_frame.setVisible(true);
        com_frame.pack();
        com_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jmenuitemAbout){
            JOptionPane.showMessageDialog(null, "Home Work 2\n GUI");
        }else if(e.getSource() == jmenuitemExit){
            System.exit(0);
        }
    }


}

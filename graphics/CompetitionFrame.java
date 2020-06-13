package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Class that describes an competition attributes
 * @author Eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class CompetitionFrame extends JFrame implements ActionListener, Runnable {

    private JMenu jmenuFile, jmenuHelp;
    private JMenuItem jmenuitemExit, jmenuitemAbout;
    private CompetitionPanel pan;
    private boolean regular;
    private String competition_name;
    /**
     * Default Ctor, for the competition frame (GUI part)
     */
    public CompetitionFrame (boolean regular, String competition_name) {
        super(competition_name);
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

        this.regular = regular;
        this.pan = new CompetitionPanel(regular, this);
        this.add(pan);

        jmenuitemAbout.addActionListener(this);
        jmenuitemExit.addActionListener(this);

    }

    public CompetitionFrame (boolean choice) {
        super("competition");
        this.regular = choice;
    }

    public CompetitionPanel get_Fpan(){
        return this.pan;
    }

    /**
     * main method to start the GUI frame
     * @param args
     */
    public static void main(String args[]) {
        try {
            start_frame(true);
            start_frame(false);
        }catch (Exception e){
            System.out.println("Hi, Try again");
        }

    }

    public void frame() {
        this.regular = !this.regular;
        if (regular){
            competition_name = "Regular Tournament";
        }
        else {
            competition_name = "Courier Tournament";
        }
        CompetitionFrame com_frame = new CompetitionFrame(regular, competition_name);
        com_frame.setVisible(true);
        com_frame.setResizable(false);
        com_frame.pack();
        com_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void start_frame(boolean choice) {
        CompetitionFrame temp = new CompetitionFrame(choice);
        Thread temp_thread = new Thread(temp);
        temp_thread.start();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jmenuitemAbout){
            JOptionPane.showMessageDialog(null, "Home Work 2\n GUI");
        }else if(e.getSource() == jmenuitemExit){
            System.exit(0);
        }
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (this){
            try{
                frame();
            }
            catch (Exception e){
                System.out.println("Hi, Try again");
            }
        }
    }
}

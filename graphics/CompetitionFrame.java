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
public class CompetitionFrame extends JFrame implements ActionListener, Runnable
{
    private JMenu jmenuFile, jmenuHelp;
    private JMenuItem jmenuitemExit, jmenuitemAbout;
    private CompetitionPanel pan;

    /**
     * Default Ctor, for the competition frame (GUI part)
     */
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

    public CompetitionPanel get_Fpan(){
        return this.pan;
    }

    /**
     * main method to start the GUI frame
     * @param args
     */
    public static void main(String args[])
    {
        try{
            CompetitionFrame temp = new CompetitionFrame();
            Thread temp_thread = new Thread(temp);
            temp_thread.start();

            CompetitionFrame temp1 = new CompetitionFrame();
            Thread temp_thread1 = new Thread(temp);
            temp_thread1.start();
        }
        catch (Exception e){
            System.out.println("Hi, Try again");
        }

    }

    public static void frame()
    {
        CompetitionFrame com_frame = new CompetitionFrame();
        com_frame.setVisible(true);
        com_frame.setResizable(false);
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

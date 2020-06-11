package animals;

import threads.RegularTournament;

import javax.swing.*;

import static graphics.CompetitionPanel.*;


public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    static Boolean winner = false;


    static int sleep;

    public AnimalThread() {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = false;
        this.finishFlag = false;
        sleep = 888;
    }

    public AnimalThread(Animal participant, Boolean startFlag, Boolean finishFlag) {
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        sleep = 888;
    }

    public void set_max_dic(double d){
        this.participant.set_max_distance(d);
    }

    public double get_max_dic(){
        return this.participant.get_max_distance();
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     */

    public static void print_mas(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void run() {

        if(start_courier){
            System.out.println("blob");
        }




        if(start_regular){
            synchronized (this.participant) {
                synchronized(start_flag){
                    if (!start_flag){
                        try {print_mas("The competition starts another 5 seconds from now.\n" +
                                "The end","Start competition");
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        start_flag = true;
                    }
                }
                while (!winner) {
                    System.out.println(this.participant.getLocation());
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(winner){
                        break;
                    }
                    if(Thread.interrupted()){
                        print_mas("ERROR","ERROR");
                    }
                    this.participant.eat(5); // The animal moves

                    if (this.participant.get_max_distance() <= this.participant.getLocation().getX()) {
                        if(winner){
                            break;
                        }
                        winner = true;
                        int index_of;
                        String type;
                        index_of = this.participant.getClass().getName().indexOf("$");
                        if(index_of == -1){
                            type = this.participant.getClass().getName().substring(8);
                        }
                        else {
                            type = this.participant.getClass().getName().substring(8,index_of);
                        }
                        String mas = "the winner is :" + this.participant.get_name() + " the " + type;
                        print_mas(mas,"WINNER!");

                        System.exit(0);
                    }
                }
            }
        }
    }
}


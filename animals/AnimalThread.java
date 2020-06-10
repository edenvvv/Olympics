package animals;

import threads.RegularTournament;

import javax.swing.*;


public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;

    private RegularTournament rt;

    static int sleep;

    public AnimalThread() {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = false;
        this.finishFlag = false;
        sleep = 888;
    }

    public AnimalThread(Animal participant, Boolean startFlag, Boolean finishFlag, RegularTournament rt) {
        this.rt = rt;
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        sleep = 888;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     */

    public static void winner_mas(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void run() {

        /*
        if(Thread.interrupted()){
            System.out.println("BLOB");
        }*/

        synchronized (this.participant) {
            while (true) {
                System.out.println(this.participant.getLocation());
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.participant.eat(5); // The animal moves

                if (this.participant.get_max_distance() <= this.participant.getLocation().getX()) {
                    int index_of;
                    String type;
                    index_of = this.participant.getClass().getName().indexOf("$");
                    if(index_of == -1){
                        type = this.participant.getClass().getName().substring(8);
                    }
                    else {
                        type = this.participant.getClass().getName().substring(8,index_of);
                    }
                    String mas = "the winner is :" + this.participant.get_name() +" the "+ type;
                    winner_mas(mas,"WINNER!");
                    rt.stop_threads();
                    System.exit(0);
                    
                }
            }
        }

        /*try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


         /*
        for (int i = 0; i < 200; ++i) {
            System.out.println(this.participant.getLocation());
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.participant.eat(2); // The animal moves
            //this.participant.get_pan().repaint();
        }
        */
    }

}


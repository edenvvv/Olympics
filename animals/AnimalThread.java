package animals;

import graphics.CompetitionFrame;
import graphics.CompetitionPanel;

import java.util.Timer;
import java.util.TimerTask;

public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;

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
        //this.pan = pan;
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        sleep = 888;
    }

    public AnimalThread(Boolean startFlag, Boolean finishFlag) {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
    }

    public AnimalThread(double neededDistance, Boolean startFlag, Boolean finishFlag) {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = neededDistance;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     */
    @Override
    public void run() {

        /*
        synchronized (this.startFlag){
            while (!this.startFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.startFlag = false;
            notify();
        }

        if(Thread.interrupted()){
            System.out.println("BLOB");
        }

        synchronized (this.participant){
            for (int i=0; i<12;++i) {
                this.participant.get_pan().repaint();
                this.participant.eat(8); // The animal moves

                if (this.participant.get_distance() >= this.neededDistance) {
                    this.finishFlag = true;
                    notify();
                }
            }
        }

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


         */
        for (int i = 0; i < 12; ++i) {
            System.out.println(this.participant.getLocation());
            this.participant.eat(2); // The animal moves
            this.participant.get_pan().repaint();
        }
    }

}


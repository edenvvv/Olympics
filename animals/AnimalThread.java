package animals;

import graphics.CompetitionFrame;
import graphics.CompetitionPanel;

public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    private CompetitionPanel pan;

    static int sleep;

    public AnimalThread(Animal participant, CompetitionPanel pan) {
        this.pan = pan;
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = false;
        this.finishFlag = false;
        sleep = 88;
    }

    public AnimalThread(Animal participant,double neededDistance, CompetitionPanel pan) {
        this.pan = pan;
        this.participant = participant;
        this.neededDistance = neededDistance;
        this.startFlag = false;
        this.finishFlag = false;
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
            this.participant.eat(8); // The animal moves
            pan.repaint();

            if(this.participant.get_distance() >= this.neededDistance){
                this.finishFlag = true;
                notify();
            }
        }

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}


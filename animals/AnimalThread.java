package animals;

public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;

    public AnimalThread() {
        this.neededDistance = 8;
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
        start_Flag();
    }

    public synchronized void start_Flag() {
        while (!this.startFlag) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.startFlag = false;
        notify();
    }
}


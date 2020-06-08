package threads;

public class Referee implements Runnable{
    private String name;
    private Scores scores;
    private Boolean come;

    public Referee(String name,Scores score){
        this.scores = score;
        this.name = name;
        this.come = false;
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
        synchronized (this.come){
            while (!this.come) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.scores.add(this.name);
                this.come = false;
                notify();
            }
        }
    }
}

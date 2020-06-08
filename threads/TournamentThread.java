package threads;

public class TournamentThread implements Runnable {
    private Scores scores;
    private Boolean startSignal;
    private int groups;

    public TournamentThread(){
        this.scores = new Scores();
        this.startSignal = false;
        this.groups = 2;
    }

    public int get_groups_size(){
        return this.groups;
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
        this.startSignal = true;
        
    }
}

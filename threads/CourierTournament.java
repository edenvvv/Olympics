package threads;

import animals.Animal;
import animals.AnimalThread;
import mobility.Point;

import java.util.Vector;

public class CourierTournament extends Tournament {
    private Vector<Thread> courier_threads = new Vector<>();
    public static Vector<Point> Locations = new Vector<>();
    public static Vector<Animal> animal_arr = new Vector<>();
    private Thread thread;
    private int max = 30;
    private Boolean start_Flag;
    private Boolean finish_Flag;

    public CourierTournament(Animal[][] setup_arr){
        super(setup_arr);
        this.thread = new Thread();
        this.start_Flag = false;
        this.finish_Flag = false;
    }
    @Override
    public void setup(Animal[][] setup_arr) {
        Boolean startFlag = false;
        Scores scores = new Scores();

        for (int i=0; i < setup_arr.length; ++i){
            Boolean finishFlag = false;
            Referee temp_referee = new Referee(String.valueOf(i+1),scores,finishFlag);
        }
    }

    public void set_threads(Animal[][] setup_arr,Animal animal, int i, Boolean start_courier, Boolean start_regular){

        setup_arr[0][i] = animal;
        Locations.add(i,animal.getLocation());
        AnimalThread temp = new AnimalThread(animal, start_Flag , finish_Flag, start_courier, start_regular);
        Thread temp_thread = new Thread(temp);
        this.thread = temp_thread;
        animal_arr.add(temp.get_animal());
        courier_threads.add(i,temp_thread);
        courier_threads.get(i).start();


    }

    public void init_threads(){
        for (int i=0; i < max; ++i){
            courier_threads.add(i,new Thread());
        }
    }

    public void stop_threads(){
        for (int i=0; i < max; ++i){
            courier_threads.get(i).stop();
        }
    }

    public void suspend_threads(){
        this.thread.suspend();
    }

    public void resume_threads(){
        this.thread.resume();
    }

}

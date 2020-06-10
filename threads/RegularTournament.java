package threads;

import animals.Animal;
import animals.AnimalThread;
import graphics.CompetitionPanel;

import java.util.Vector;

public class RegularTournament extends Tournament {
    private Vector<Thread> threads = new Vector<>();
    private int max = 8;

    public RegularTournament(Animal[][] setup_arr){
        super(setup_arr);
    }
    @Override
    public void setup(Animal[][] setup_arr) {
        Boolean startFlag = false;
        Scores scores = new Scores();

        for (int i=0; i < setup_arr.length; ++i){
            Boolean finishFlag = false;
            AnimalThread temp = new AnimalThread(setup_arr[i][0], startFlag , finishFlag);
            Thread temp_thread = new Thread(temp);

            //temp_thread.start();
            Referee temp_referee = new Referee(String.valueOf(i+1),scores,finishFlag);
        }
        /*
        special.add(startFlag);
        special.add(scores);
        special.add(setup_arr.length);
        */
    }

    public void start_threads(){
        for (int i=0; i < threads.size(); ++i){
            threads.get(i).start();
        }
    }

    public void start_lastElement_threads(){
        threads.lastElement().start();
    }

    public void set_threads(Animal[][] setup_arr,Animal animal, int i){
        setup_arr[i][0] = animal;
        AnimalThread temp = new AnimalThread(animal, false , false);
        Thread temp_thread = new Thread(temp);
        threads.set(i,temp_thread);
        threads.get(i).start();
    }

    public void init_threads(){
        for (int i=0; i < max; ++i){
            threads.add(i,new Thread());
        }
    }


}

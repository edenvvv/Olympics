package threads;

import animals.Animal;
import animals.AnimalThread;

import java.util.Vector;

public class RegularTournament extends Tournament {
    private Vector<Object> special = new Vector<>();

    @Override
    public void setup(Animal[][] setup_arr) {
        Boolean startFlag = false;
        Scores scores = new Scores();

        for (int i=0; i < setup_arr.length; ++i){
            Boolean finishFlag = false;
            AnimalThread temp = new AnimalThread(setup_arr[i][0], startFlag , finishFlag);
            Thread temp_thread = new Thread(temp);
            temp_thread.start();
            Referee temp_referee = new Referee(String.valueOf(i+1),scores,finishFlag);
        }
        special.add(startFlag);
        special.add(scores);
        special.add(setup_arr.length);
    }
}

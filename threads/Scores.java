package threads;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Scores {
    private Map<String, Date> scores;

    public Scores(){
        this.scores = Collections.synchronizedMap(new HashMap());
    }

    public void add(String name){
        Date time = new Date();
        this.scores.put(name,time);
    }

    public Map<String, Date> getAll(){
        return this.scores;
    }
}

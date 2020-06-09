package threads;

import animals.Animal;

public abstract class Tournament {
    protected TournamentThread tournament;

    public Tournament(){
        this.tournament = new TournamentThread();
        setup(new Animal[this.tournament.get_groups_size()][]);
    }


    public Tournament(Animal[][] setup_arr){
        this.tournament = new TournamentThread();
        setup(setup_arr);
    }

    public TournamentThread get_TournamentThread(){
        return this.tournament;
    }

    public abstract void setup(Animal[][] setup_arr);
}

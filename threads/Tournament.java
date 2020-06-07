package threads;

import animals.Animal;

public abstract class Tournament {
    protected TournamentThread tournament;

    public Tournament(){
        this.tournament = new TournamentThread();
        setup(new Animal[this.tournament.get_groups_size()][]);
    }

    public TournamentThread get_TournamentThread(){
        return this.tournament;
    }

    public abstract void setup(Animal[][] setup_arr);
}

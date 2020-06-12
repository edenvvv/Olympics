package animals;

import threads.CourierTournament;

import javax.swing.*;

import static graphics.CompetitionPanel.*;
import static threads.CourierTournament.*;


public class AnimalThread implements Runnable {

    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    static Boolean winner = false;
    private CourierTournament courier;
    private int animali1 = 0;
    private int animali2 = 3;
    private int animali3 = 6;


    static int sleep;

    public AnimalThread() {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = false;
        this.finishFlag = false;
        sleep = 888;
    }

    public AnimalThread(Animal participant, Boolean startFlag, Boolean finishFlag) {
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        sleep = 888;
    }

    public AnimalThread(Animal participant, Boolean startFlag, Boolean finishFlag, CourierTournament courier) {
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        this.courier = courier;
        sleep = 888;
    }

    public void set_animal(Animal a){
        this.participant = a;
    }

    public Animal get_animal(){
        return this.participant;
    }

    public void set_max_dic(double d){
        this.participant.set_max_distance(d);
    }

    public double get_max_dic(){
        return this.participant.get_max_distance();
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     */

    public static void print_mas(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void run() {

        if (start_courier) {
            synchronized (this) {
                while (Locations.size() < 9) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notifyAll();
                while (true) {
                    animal_arr.get(animali1).eat(5); // The animal moves
                    animali1 += 3;
                    animal_arr.get(animali2).eat(5); // The animal moves
                    animali2 += 3;
                    animal_arr.get(animali3).eat(5); // The animal moves
                    animali3 += 3;
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (animali1 >= 3) {
                        animali1 -= 3;
                    }
                    if (animali2 >= 3) {
                        animali2 -= 3;
                    }
                    if (animali3 >= 3) {
                        animali3 -= 3;
                    }
                    System.out.println(animal_arr.get(animali1).getLocation().getX());
                    System.out.println(animal_arr.get(animali1 + 1).getLocation().getX());
                    if (animal_arr.get(animali1).getLocation().getX() >= animal_arr.get(animali1 + 1).getLocation().getX() - 62) {
                        ++animali1;
                    }
                    animali1 += 3;
                    if (animal_arr.get(animali2).getLocation().getX() >= animal_arr.get(animali2 + 1).getLocation().getX() - 62) {
                        ++animali2;
                    }
                    animali2 += 3;
                    if (animal_arr.get(animali3).getLocation().getX() >= animal_arr.get(animali3 + 1).getLocation().getX() - 62) {
                        ++animali3;
                    }
                    animali3 += 3;
                    if (animali1 >= 3) {
                        animali1 -= 3;
                    }
                    if (animali2 >= 3) {
                        animali2 -= 3;
                    }
                    if (animali3 >= 3) {
                        animali3 -= 3;
                    }
                }
            }
        }




        if(start_regular){
            synchronized (this.participant) {
                synchronized(start_flag){
                    if (!start_flag){
                        try {print_mas("The competition starts another 5 seconds from now.\n" +
                                "The end","Start competition");
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        start_flag = true;
                    }
                }
                while (!winner) {
                    System.out.println(this.participant.getLocation());
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(winner){
                        break;
                    }
                    if(Thread.interrupted()){
                        print_mas("ERROR","ERROR");
                    }
                    this.participant.eat(5); // The animal moves

                    if (this.participant.get_max_distance() <= this.participant.getLocation().getX()) {
                        if(winner){
                            break;
                        }
                        winner = true;
                        int index_of;
                        String type;
                        index_of = this.participant.getClass().getName().indexOf("$");
                        if(index_of == -1){
                            type = this.participant.getClass().getName().substring(8);
                        }
                        else {
                            type = this.participant.getClass().getName().substring(8,index_of);
                        }
                        String mas = "the winner is :" + this.participant.get_name() + " the " + type;
                        print_mas(mas,"WINNER!");

                        System.exit(0);
                    }
                }
            }
        }
    }
}


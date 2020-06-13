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
    private JFrame my_frame;

    private Boolean start_courier;
    private Boolean start_regular;


    static int sleep;

    public AnimalThread() {
        //this.pan = pan;
        //this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = false;
        this.finishFlag = false;
        sleep = 888;
    }

    public AnimalThread(Animal participant, Boolean startFlag, Boolean finishFlag, Boolean start_courier, Boolean start_regular, JFrame my_frame) {
        this.participant = participant;
        this.neededDistance = 8;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        this.start_courier = start_courier;
        this.start_regular = start_regular;
        this.my_frame = my_frame;
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
                while (Locations.size() < 6) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notifyAll();
                while (true) {
                    animal_arr.get(animali1).eat(5); // The animal moves
                    animal_arr.get(animali2).eat(5); // The animal moves
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (animali1 != 2){
                        if (animal_arr.get(animali1).getLocation().getX() >= animal_arr.get(animali1 + 1).getLocation().getX() - 62) {
                            ++animali1;
                        }
                    }

                    if (animali2 <= 4){
                        if (animal_arr.get(animali2).getLocation().getX() >= animal_arr.get(animali2 + 1).getLocation().getX() - 62) {
                            ++animali2;
                        }
                    else if (animali2 == 5){
                            ++animali2;
                        }
                    }
                    if (animal_arr.get(animali1).get_max_distance() + 30 <= animal_arr.get(animali1).getLocation().getX()) {
                        print_mas("the winner is : team 1!","WINNER!");
                        exit_frame(this.my_frame);
                        break;
                    }

                    else if (animal_arr.get(animali2).get_max_distance() + 30 <= animal_arr.get(animali2).getLocation().getX()) {
                        print_mas("the winner is : team 2!","WINNER!");
                        exit_frame(this.my_frame);
                        break;
                    }
                }
            }
        }




        else if(start_regular){
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
                    //System.out.println(this.participant.getLocation());
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

                        exit_frame(this.my_frame);
                    }
                }
            }
        }
    }
}


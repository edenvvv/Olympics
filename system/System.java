package system;
import Olympics.Medal;
import animals.*;
import mobility.Point;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Main
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public class System {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        try {

            java.lang.System.out.println("Enter the num of the animals:");
            Scanner input = new Scanner(java.lang.System.in);
            int num_of_animals = input.nextInt();

            Animal[] array = new Animal[num_of_animals];

            for (int i = 0; i < num_of_animals; ++i) {
                Choose_Menu(array, i);
            }
            java.lang.System.out.println("this is all the animal's you chose:");
            for (int i = 0; i < num_of_animals; ++i) {
                java.lang.System.out.println("(" + (i + 1) + ")" + " is a " + array[i].getClass().getName());
            }
            Actions_Menu(array);
        }
        catch(NegativeArraySizeException e)
        {
            java.lang.System.out.println("you entered negative value to your amount of animals. Please try again, with positive number.");
            main(args);
        }
    }

    /**
     * Once all the animals are selected by the user, a menu will open which has 3 options:
     * 1 - Information on each animal selected.
     * 2 - The sound the animal makes.
     * 3 - Exit the system.
     * If the user chooses an option that is not from the list -
     * an exception is thrown and the option is repeated.
     * @param array
     * @throws InvalidParameterException
     */
    public static void Actions_Menu(Animal[] array)
    {
        Scanner input = new Scanner(java.lang.System.in);
        while(true) {
            java.lang.System.out.println("What do you want to do with your animals? (1) - info about the animal, (2) - animal sound, (3) - exit");
            try {
                int option = input.nextInt();
                if (option == 1) {
                    for(int i =0; i< array.length; ++i) {
                        java.lang.System.out.println("(" + (i+1) + ") " + array[i].getClass().getName() + " - " + array[i].toString());
                    }
                }
                else if (option == 2) {
                    for(int i =0; i< array.length; ++i) {
                        array[i].makeSound();
                    }
                }
                else if (option == 3)
                    break;
                else
                    throw new InvalidParameterException();
            }

            catch(InvalidParameterException e)
            {
                java.lang.System.out.println("the option you chose isn't from the available options. Please, try again.");
                Actions_Menu(array);
            }
        }
    }


    /**
     * A menu where the user can choose what type of animal they want from 3 families:
     * 1 - air
     * 2 - water
     * 3 - terrestrial.
     * If the user chooses an option that is not from the list -
     * an exception is thrown and given them another option.
     * @param array
     * @param i - counter (the location in the Animal array - "array[i]")
     * @throws InvalidParameterException
     */
    public static void Choose_Menu(Animal[] array, int i)
    {
        java.lang.System.out.println("insert which kind of animal do you want: (Air, Water, Terrestrial)");
        Scanner input_type = new Scanner(java.lang.System.in);
        String option = input_type.nextLine().toLowerCase();

        try {
            switch (option) {
                case "air":
                    Air_Menu(array, i);
                    break;

                case "water":
                    Water_Menu(array, i);
                    break;

                case "terrestrial":
                    Terrestrial_Menu(array, i);
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }

        catch (InvalidParameterException e)
        {
            java.lang.System.out.println("we cant found the Type-Animal you chose, please try again. ");
            Choose_Menu(array,i);
        }
    }

    /**
     * Specific menu of the Air-Animal Family.
     * Where two animals can be selected:
     *  - Eagle
     *  - Pigeon
     * If the user chooses not an option from the list -
     * exception is thrown and given another choice.
     *
     * @param array
     * @param i - counter (the location in the Animal array - "array[i]")
     * @throws InvalidParameterException
     */
    public static void Air_Menu(Animal[] array, int i)
    {
        java.lang.System.out.println("Which Air-Animal do you want to choose: (Eagle, Pigeon)");
        Scanner input = new Scanner(java.lang.System.in);
        String option = input.next().toLowerCase();
        Scanner bool_input = new Scanner(java.lang.System.in);
        boolean choice;
        try
        {
            switch (option)
            {
                case "eagle":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Eagle();
                    }
                    else {

                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the wingspan:");
                        double wingspan = input_data.nextDouble();
                        java.lang.System.out.println("Enter the altitude Of Flight:");
                        double altitudeOfFlight = input_data.nextFloat();
                        array[i] = new Eagle(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), wingspan,altitudeOfFlight);
                    }
                    break;

                case "pigeon":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Pigeon();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the wingspan:");
                        double wingspan = input_data.nextDouble();
                        java.lang.System.out.println("Enter the family:");
                        String family = input_data.next();
                        array[i] = new Pigeon(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), wingspan,family);
                    }
                    break;

                default:
                    throw new InvalidParameterException();

            }

        }
        catch (Exception e)
        {
            java.lang.System.out.println("Something went wrong, please try again. ");
            Air_Menu(array,i);
        }


    }


    /**
     * Specific menu of the Water-Animal Family.
     * Where three animals can be selected:
     *  - Alligator
     *  - Whale
     *  - Dolphin
     * If the user chooses not an option from the list -
     * exception is thrown and given another choice.
     *
     * @param array
     * @param i - counter (the location in the Animal array - "array[i]")
     * @throws InvalidParameterException
     *
     */
    public static void Water_Menu(Animal[] array, int i)
    {
        java.lang.System.out.println("Which Water-Animal do you want to choose: (Alligator, Whale, Dolphin)");
        Scanner input = new Scanner(java.lang.System.in);
        String option = input.next().toLowerCase();
        Scanner bool_input = new Scanner(java.lang.System.in);
        boolean choice;
        try {
            switch (option) {
                case "alligator":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Alligator();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the diveDept:");
                        double diveDept = input_data.nextDouble();
                        java.lang.System.out.println("Enter the Area Of Living:");
                        String AreaOfLiving = input_data.next();
                        array[i] = new Alligator(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), diveDept,AreaOfLiving);
                    }
                    break;

                case "whale":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Whale();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the diveDept:");
                        double diveDept = input_data.nextDouble();
                        java.lang.System.out.println("Enter the food Type:");
                        String foodType = input_data.next();
                        array[i] = new Whale(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), diveDept,foodType);
                    }
                    break;

                case "dolphin":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Dolphin();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the diveDept:");
                        double diveDept = input_data.nextDouble();
                        java.lang.System.out.println("Enter 1 for Sea, 2 for Sweet");
                        int choice_Water_Type = input_data.nextInt();
                        Dolphin.WaterType Water_Type;
                        if (choice_Water_Type == 1){
                            Water_Type = Dolphin.WaterType.Sea ;
                        }
                        else if (choice_Water_Type == 2){
                            Water_Type = Dolphin.WaterType.Sweet ;
                        }
                        else {
                            throw new InvalidParameterException();
                        }
                        array[i] = new Dolphin(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), diveDept,Water_Type);
                    }
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }
        catch (Exception e)
        {
            java.lang.System.out.println("Something went wrong, please try again. ");
            Water_Menu(array,i);
        }


    }

    /**
     * * Specific menu of the Terrestrial-Animal Family.
     * Where three animals can be selected:
     *  - Dog
     *  - Cat
     *  - Snake
     * If the user chooses not an option from the list -
     * exception is thrown and given another choice.
     *
     * @param array
     * @param i - counter (the location in the Animal array - "array[i]")
     * @throws InvalidParameterException
     */
    public static void Terrestrial_Menu(Animal[] array, int i)
    {
        java.lang.System.out.println("Which Terrestrial-Animal do you want to choose: (Dog , Cat, Snake)");
        Scanner input = new Scanner(java.lang.System.in);
        String option = input.next().toLowerCase();
        Scanner bool_input = new Scanner(java.lang.System.in);
        boolean choice;
        try {
            switch (option) {
                case "dog":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Dog();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the num of Legs:");
                        int noLegs = input_data.nextInt();
                        java.lang.System.out.println("Enter the breed:");
                        String breed = input_data.next();
                        array[i] = new Dog(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), noLegs,breed);
                    }
                    break;

                case "cat":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Cat();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter the num of Legs:");
                        int noLegs = input_data.nextInt();
                        java.lang.System.out.println("Enter if Castrated? (true, false)");
                        boolean Castrated = input_data.nextBoolean();
                        array[i] = new Cat(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(), noLegs,Castrated);
                    }
                    break;

                case "snake":
                    java.lang.System.out.println("Do you want us to give default values? (true, false)");
                    choice = bool_input.nextBoolean();
                    if(choice) {
                        array[i] = new Snake();
                    }
                    else {
                        Scanner input_data = new Scanner(java.lang.System.in);
                        Animal_like animal_data = input_Animal();
                        java.lang.System.out.println("Enter length:");
                        double length = input_data.nextDouble();
                        java.lang.System.out.println("Enter 1 for low, 2 for Medium, 3 for high");
                        int choice_Poisonous = input_data.nextInt();
                        Snake.Poisonous pois;
                        if (choice_Poisonous == 1){
                            pois = Snake.Poisonous.low ;
                        }
                        else if (choice_Poisonous == 2){
                            pois = Snake.Poisonous.Medium ;
                        }
                        else if (choice_Poisonous == 3){
                            pois = Snake.Poisonous.high ;
                        }
                        else {
                            throw new InvalidParameterException();
                        }
                        array[i] = new Snake(animal_data.get_name(), animal_data.get_gender(), animal_data.get_weight(),
                                animal_data.get_speed(), animal_data.get_medals(), animal_data.get_position(),length,pois);
                    }
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }
        catch (Exception e)
        {
            java.lang.System.out.println("Something went wrong, please try again. ");
            Terrestrial_Menu(array,i);
        }

    }

    private static Medal[] input_medals(){
        java.lang.System.out.println("How many medals you want to put in?");
        Scanner input = new Scanner(java.lang.System.in);
        int size = input.nextInt();
        Medal[] medals = new Medal[size];
        Scanner input_data = new Scanner(java.lang.System.in);
        for (int i = 0; i < size; ++i){
            java.lang.System.out.println("Enter 1 for bronze, 2 for silver and 3 for gold:");
            int choice_gender = input_data.nextInt();
            Medal.types type ;
            if (choice_gender == 1){
                type = Medal.types.bronze ;
            }
            else if (choice_gender == 2){
                type = Medal.types.silver ;
            }
            else if (choice_gender == 3){
                type = Medal.types.gold ;
            }
            else {
                throw new InvalidParameterException();
            }
            java.lang.System.out.println("Enter The name of the tournament:");
            String tournament = input_data.next();
            java.lang.System.out.println("Enter the year:");
            int year = input_data.nextInt();
            medals[i] = new Medal(type, tournament, year);
        }
        return medals;
    }

    /**
     * Receives the animal data as input from the user
     * @return Animal_like object
     */
    private static Animal_like input_Animal(){
        Scanner input_data = new Scanner(java.lang.System.in);
        java.lang.System.out.println("Enter the name:");
        String name = input_data.next();
        java.lang.System.out.println("Enter 1 for Male, 2 for Female and 3 for Hermaphrodite");
        int choice_gender = input_data.nextInt();
        Animal.gender my_genders ;
        if (choice_gender == 1){
            my_genders = Animal.gender.Male ;
        }
        else if (choice_gender == 2){
            my_genders = Animal.gender.Female ;
        }
        else if (choice_gender == 3){
            my_genders = Animal.gender.Hermaphrodite ;
        }
        else {
            throw new InvalidParameterException();
        }
        java.lang.System.out.println("Enter the weight:");
        double weight = input_data.nextDouble();
        java.lang.System.out.println("Enter the speed:");
        double speed = input_data.nextDouble();
        Medal[] medals = input_medals();
        java.lang.System.out.println("Enter the position (x,y)");
        java.lang.System.out.println("x:");
        int x = input_data.nextInt();
        java.lang.System.out.println("y:");
        int y = input_data.nextInt();
        Point position = new Point(x,y);

        return new Animal_like(name, my_genders, weight, speed, medals, position);
    }

    /**
     * A class that receives parameters identical to Animal
     */
    static class Animal_like{

        private Animal.gender my_genders;
        private String name;
        private double weight;
        private double speed;
        private Medal[] medals;
        private Point position;

        /**
         * @param name
         * @param my_genders
         * @param weight
         * @param speed
         * @param medals
         * @param position
         */
        public Animal_like(String name, Animal.gender my_genders, double weight, double speed, Medal[] medals, Point position){
            this.name = name;
            this.my_genders = my_genders;
            this.weight = weight;
            this.speed = speed;
            this.medals = medals;
            this.position = position;
        }

        /**
         * Get the name of the animal
         * @return name
         */
        public String get_name(){
            return this.name;
        }

        /**
         * Return the gender of the animal
         * @return gender
         */
        public Animal.gender get_gender(){
            return this.my_genders;
        }

        /**
         * Get the weight of the animal
         * @return weight
         */
        public double get_weight(){
            return this.weight;
        }

        /**
         * Protected: get the speed of the animal
         * @return speed of animal
         */
        public double get_speed(){
            return this.speed;
        }

        /**
         * Protected: get the medals of the animal
         * @return speed of animal
         */
        public Medal[] get_medals(){
            return this.medals;
        }

        /**
         * Protected: get the position of the animal
         * @return speed of animal
         */
        public Point get_position(){
            return this.position;
        }
    }
}
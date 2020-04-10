package system;
import animals.*;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 * Main
 */
public class Main {

    public static void main(String[] args) {
        try {

            System.out.println("Enter the num of  the animals:");
            Scanner input = new Scanner(System.in);
            int num_of_animals = input.nextInt();

            Animal[] array = new Animal[num_of_animals];

            for (int i = 0; i < num_of_animals; ++i) {
                Choose_Menu(array, i);
            }
            System.out.println("this is all the animal's you chose:");
            for (int i = 0; i < num_of_animals; ++i) {
                System.out.println("(" + (i + 1) + ")" + " is a " + array[i].getClass().getName());
            }
            Actions_Menu(array);
        }
        catch(NegativeArraySizeException e)
        {
            System.out.println("you entered negative value to your amount of animals. Please try again, with positive number.");
            main(args);
        }
    }

    public static void Actions_Menu(Animal[] array)
    {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("What do you want to do with your animals? 1 - info about the animal, 2 - animal sound, 3 - exit");
            try {
                int option = input.nextInt();
                if (option == 1) {
                    for(int i =0; i< array.length; ++i) {
                        System.out.println("(" + (i+1) + ") " + array[i].getClass().getName() + " - " + array[i].toString());
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
                System.out.println("the option you chose isn't from the available options. Please, try again.");
                Actions_Menu(array);
            }
        }
    }


    public static void Choose_Menu(Animal[] array, int i)
    {
        System.out.println("insert which kind of animal do you want: (Air, Water, Terrestrial)");
        Scanner input_type = new Scanner(System.in);
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
            System.out.println("we cant found the Type-Animal you chose, please try again. ");
            Choose_Menu(array,i);
        }
    }

    public static void Air_Menu(Animal[] array, int i)
    {
        System.out.println("Which Air-Animal do you want to choose: (Eagle, Pigeon)");
        Scanner input = new Scanner(System.in);
        String option = input.next().toLowerCase();

        try
        {
            switch (option)
            {
                case "eagle":
                    array[i] = new Eagle();
                    break;

                case "pigeon":
                    array[i] = new Pigeon();
                    break;

                default:
                    throw new InvalidParameterException();

            }

        }
        catch (InvalidParameterException e)
        {
            System.out.println("we cant found the animal you chose, please try again. ");
            Air_Menu(array,i);
        }


    }

    public static void Water_Menu(Animal[] array, int i)
    {
        System.out.println("Which Water-Animal do you want to choose: (Alligator, Whale, Dolphin)");
        Scanner input = new Scanner(System.in);
        String option = input.next().toLowerCase();
        try {
            switch (option) {
                case "alligator":
                    array[i] = new Alligator();
                    break;

                case "whale":
                    array[i] = new Whale();
                    break;

                case "dolphin":
                    array[i] = new Dolphin();
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }
        catch (InvalidParameterException e)
        {
            System.out.println("we cant found the animal you chose, please try again. ");
            Water_Menu(array,i);
        }


    }

    public static void Terrestrial_Menu(Animal[] array, int i)
    {
        System.out.println("Which Terrestrial-Animal do you want to choose: (Dog , Cat, Snake)");
        Scanner input = new Scanner(System.in);
        String option = input.next().toLowerCase();
        try {
            switch (option) {
                case "dog":
                    array[i] = new Dog();
                    break;

                case "cat":
                    array[i] = new Cat();
                    break;

                case "snake":
                    array[i] = new Snake();
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }
        catch (InvalidParameterException e)
        {
            System.out.println("we cant found the animal you chose, please try again. ");
            Terrestrial_Menu(array,i);
        }

    }
}
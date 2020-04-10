package system;
import Olympics.*;
import mobility.*;
import animals.*;

/**
 * eden dadon id:207279183
 * Eliran Dagan id: 208061580
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Medal medal = new Medal();
        System.out.println(medal.toString());
        /*
        mobility.Point p = new mobility.Point(1,3);
        mobility.Mobile mobile = new mobility.Mobile(p);
        System.out.println(mobile.toString());
        mobility.Point point = new mobility.Point(5,8);
        mobile.move(point);
        System.out.println(mobile.toString());
        point.setX(10);
        point.setY(10);
        mobile.move(point);
        System.out.println(mobile.toString());
        */
        /*
        Animal x = new Animal();
        System.out.println(x.toString());
        */

        Medal[] arr = new Medal[] {new Medal()};
        Dog d = new Dog();
        System.out.println(d.toString());
        d.makeSound();

        Dog s1 = new Dog("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, "blob");
        System.out.println(s1.toString());
        s1.makeSound();

        Cat c = new Cat();
        System.out.println(c.toString());
        c.makeSound();

        Cat s2 = new Cat("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, true);
        System.out.println(s2.toString());
        s2.makeSound();

        Snake s = new Snake("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, 3);
        System.out.println(s.toString());
        s.makeSound();

        Alligator a = new Alligator();
        System.out.println(a.toString());
        a.makeSound();

        Alligator s3 = new Alligator("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, "blob");
        System.out.println(s3.toString());
        s3.makeSound();

        Whale w = new Whale();
        System.out.println(w.toString());
        w.makeSound();

        Whale s4 = new Whale("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, "blob");
        System.out.println(s4.toString());
        s4.makeSound();

        Dolphin dolphin = new Dolphin();
        System.out.println(dolphin.toString());
        dolphin.makeSound();

        Dolphin s5 = new Dolphin("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, Dolphin.WaterType.Sea);
        System.out.println(s5.toString());
        s5.makeSound();

        Eagle e = new Eagle();
        System.out.println(e.toString());
        e.makeSound();

        Eagle s6 = new Eagle("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, 5.5);
        System.out.println(s6.toString());
        s6.makeSound();

        Pigeon pi = new Pigeon();
        System.out.println(pi.toString());
        pi.makeSound();

        Pigeon s7 = new Pigeon("nini",Animal.gender.Male, 3.1, 8, arr, new Point(1,8), 4, "Blob");
        System.out.println(s7.toString());
        s7.makeSound();

    }

}

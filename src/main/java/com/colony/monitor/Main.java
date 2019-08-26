package com.colony.monitor;

import com.colony.persistence.entity.Queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Matt on 04.07.2019 at 19:36.
 */
public class Main {

    public static void main(String[] args) {

        // Running a thread with standard method
        // new Thread(new CodeToRun()).start();

        // ...with anonymous fuction
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Reading sensors...");
            }
        }).start();*/

        // ...with lambda

        new Thread(() -> {
            System.out.println("Lambda sensors...");
            System.out.println("Another line of results....");
        }).start();

        // Then sorting a test list...

        List<Queen> queens = new ArrayList<>();
        Queen queen1 = new Queen(2019, "yellow", "F2");
        Queen queen2 = new Queen(2018, "red", "Sklenar");
        Queen queen3 = new Queen(2017, "green", "Beskidka");

        queens.add(queen1);
        queens.add(queen2);
        queens.add(queen3);

        // ...with anonymous method

        /*Collections.sort(queens, new Comparator<Queen>() {
            @Override
            public int compare(Queen queen1, Queen queen2) {
                return queen1.getBreed().compareTo(queen2.getBreed());
            }
        });*/

        // ...with lamdba

        Collections.sort(queens, (q1, q2) -> q1.getBreed().compareTo(q2.getBreed()));

        for (Queen queen : queens) {
            System.out.println(queen.toString());
        }

        // ...using custom interface Useable (below) and custom static method doSomething
        Useable useable = good -> ("A lot of " + good + " taken!");
        String result = doSomething(useable, "nectar");
        System.out.println(result);
        Useable useable1 = good -> "Very little " + good + " this year!";
        String result1 = doSomething(useable1, "pollen");
        System.out.println(result1);


    }

    public final static String doSomething(Useable useable, String input) {
        return useable.takeNectarOrPollen(input);
    }
}

/*class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Reading beehive sensors...");
    }
}*/

interface Useable {
    String takeNectarOrPollen(String good);
}



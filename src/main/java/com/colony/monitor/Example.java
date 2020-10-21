package com.colony.monitor;

import com.colony.persistence.entity.Queen;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Matt on 04.07.2019 at 19:36.
 */

public class Example {

    private static final Logger LOG = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {

        new Thread(() -> {
            LOG.info("Lambda sensors...");
            LOG.info("Another line of results....");
        }).start();

        List<Queen> queens = new ArrayList<>();
        Queen queen1 = new Queen(2019, "yellow", "F2");
        Queen queen2 = new Queen(2018, "red", "Sklenar");
        Queen queen3 = new Queen(2017, "green", "Beskidka");

        queens.add(queen1);
        queens.add(queen2);
        queens.add(queen3);

      queens.sort((q1, q2) -> q1.getBreed().compareTo(q2.getBreed()));

        for (Queen queen : queens) {
            LOG.info(queen.toString());
        }

        // ...using custom interface Useable (below) and custom static method doSomething
        Useable useable = good -> ("A lot of " + good + " taken!");
        String result = doSomething(useable, "nectar");
        LOG.info(result);
        Useable useable1 = good -> "Very little " + good + " this year!";
        String result1 = doSomething(useable1, "pollen");
        LOG.info(result1);
    }

    public static String doSomething(Useable useable, String input) {
        return useable.takeNectarOrPollen(input);
    }

    interface Useable {
        String takeNectarOrPollen(String good);
    }

}





package com.colony.monitor;

/**
 * Created by Matt on 04.07.2019 at 19:36.
 */
public class Main {

    public static void main(String[] args) {

        // standard method
       // new Thread(new CodeToRun()).start();

        // with anonymous fuction
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Reading sensors...");
            }
        }).start();*/

        // with lambda
        new Thread(() -> System.out.println("Lambda sensors...")).start();
    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Reading beehive sensors...");
    }
}


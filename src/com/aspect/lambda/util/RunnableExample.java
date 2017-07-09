package com.aspect.lambda.util;

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class RunnableExample {

    public static void main(String[] args) {

        Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("I am running inside Runnable");
            }
        });

        myThread.run();


        Thread myLambdaThread = new Thread(() -> System.out.println("I am running from overriding Lambda example"));

        myLambdaThread.run();
    }

}

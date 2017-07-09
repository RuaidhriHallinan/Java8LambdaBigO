package com.aspect.lambda.exercises;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class ClosuresExampleJava {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Anonymous inner class
        doProcess(a, new IProcess() {

            @Override
            public void process(int i) {
                System.out.println(i + b);
            }

        });
    }


   public static void doProcess(int i, IProcess p) {
        p.process(i);
   }

}



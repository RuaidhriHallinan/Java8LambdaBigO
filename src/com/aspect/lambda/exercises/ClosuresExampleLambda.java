package com.aspect.lambda.exercises;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class ClosuresExampleLambda {

    public static void main(String[] args) {
        int a = 10; //considered final
        int b = 20; //considered final

        // Expression
        doProcess(a, i -> System.out.println(i + b));
    }


   public static void doProcess(int i, IProcess p) {
        p.process(i);
   }

}

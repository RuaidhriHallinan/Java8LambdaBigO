package com.aspect.lambda.thisReference;

import com.aspect.lambda.exercises.IProcess;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class ThisReference {

    public static void doProcess(int i, IProcess p) {
        p.process(i);
    }

    public static void main(String[] args) {

        ThisReference thisReference = new ThisReference();
        thisReference.doProcess(10, new IProcess() {

            @Override
            public void process(int i) {

                System.out.println("Value of i is " + i);
                System.out.println(this);

            }

            public String toString() {
                return "This is an annoymous inner class";
            }
        });
    }
}

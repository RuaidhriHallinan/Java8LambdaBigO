package com.aspect.lambda.thisReference;

import com.aspect.lambda.exercises.IProcess;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class ThisRefernceLambda {

    public static void doProcess(int i, IProcess p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("The value of i is:" + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {

        ThisRefernceLambda thisReference = new ThisRefernceLambda();

        /*thisReference.doProcess(10, i -> {
            System.out.println("The value of i is:" + i);
            //System.out.println(this); wont work
        });*/

        thisReference.execute();
    }

    @Override
    public String toString() {
        return "This is the main ThisReferenceLambda class instance";
    }
}

package com.aspect.lambda.methodReference;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class MethodReferenceExample1 {

    public static void main(String[] args) {

        // Use a normal Lambda, passing/calling method with no params
        //Thread t = new Thread( () -> printMessage() );

        // Method reference alternative Lambda
        Thread t = new Thread( MethodReferenceExample1::printMessage );
        t.start();

    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}

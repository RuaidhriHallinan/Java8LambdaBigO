package com.aspect.lambda.greeting;

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello world!");
    }

}

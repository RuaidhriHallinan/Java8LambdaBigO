package com.aspect.lambda.greeting;

/**
 * Lambda expression practice
 *
 * Lambda expressions allow the passing of functions as variables
 *
 * Modifier, Return Type or Method Names do not need to be specified for passing lambda expressions
 * The complier will figure the return type out.
 *
 * You replace the Modifer, Return Type and Name (public String myFunction) with "->"
 * You can assign a Lambda expression to a variable.
 * If a Lambda expression is one line, you dont need the parenthesis brackets
 *
 *  greetingFunction = () -> {
 *      String planet = "Earth!";
 *      System.out.print("Hello " + planet);
 *  }
 *
 *  greetingFunction = () -> System.out.print("Hello World!");
 *
 *
 *  // doubleNumberFunction is a function that takes a as an integer param
 *  // and returns the value of a * 2 (which should be an int)
 *
 *  doubleNumberFunction = (int a) -> a * 2;
 *
 *
 *  // addNumbersFunction is a function that takes a as an integer param
 *  // and returns the value of a + b (which should be an int)
 *
 *  addNumbersFunction = (int a, int b) -> a + b;
 *
 *
 *  // safeDivideFunction is a function that takes two params and divides safely
 *  // by checking if b is 0 before performing the division
 *
 *  safeDivideFunction = (int a, int b) {
 *      if(b = 0) return 0;
 *      else return b;
 *  }
 *
 *  // stringLengthCountFunction is a function that takes a String param
 *  // and returns the length of the String
 *
 *  stringLengthCountFunction = (String s) -> s.length();
 *
 */
public class Greeter {

    public void greet(Greeting greeting) {
       greeting.perform();
    }

    public static void main(String [] args) {

        // Greeting helloWorldGreeting = new HelloWorldGreeting();
        // helloWorldGreeting is an implementation of the Greeting class
        // allows perform to be overridden with method in HelloWorldGreeting
        // helloWorldGreeting.perform();

        Greeting lambdaGreeting = () -> System.out.println("Hello world from Lambda!");
        // lambdaGreeting is a Lambda Expression of type Greeting interface
        // which overrides the void perform method with its own polymorphic implementation
        // in the expression
        // lambdaGreeting.perform();

        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world from anonymous inner class!");
            }
        };

        //innerClassGreeting.perform();

        Greeter greeter = new Greeter();

        greeter.greet(lambdaGreeting);
        greeter.greet(innerClassGreeting);

        // Lambda expects that the interface you use for the function
        // only have one method that is overridden So Interface Greeting, had one method

        // AddLambda addNumbersFunction = (int a, int b) -> a + b;
    }

}

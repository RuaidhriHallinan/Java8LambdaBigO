package com.aspect.lambda.greeting;

/**
 * Created by Ruaidhri on 02/07/2017.
 *
 * @FunctionalInterface ensures that the Interface only has one function
 * This, ensuring that Lambada can implement and override its single method
 * as it avoids the confusion of having more than one Interface
 *
 */
@FunctionalInterface
public interface Greeting {
    public void perform();
}

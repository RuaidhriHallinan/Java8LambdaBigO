package com.aspect.lambda.exceptions;

import java.util.function.BiConsumer;

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 2;

        //Lambda for adding each number in the array to the key
        process(someNumbers, key, (v, k) -> System.out.println(v + k));

        key = 0;
        System.out.println("Lambda for Exception handling for key with java KEY = 0");
        //Lambda for Exception handling for key with java KEY = 0
        process(someNumbers, key, (v, k) -> {
            try {
                System.out.println(v / k);
            } catch (ArithmeticException e) {
                System.out.println("An ArithmeticException Exception occurred");
            }
        });

        key = 2;
        System.out.println("Lambda for with a wrapper (returns itself) KEY = 2");
        //Lambda for with a wrapper (returns itself) KEY = 2
        process(someNumbers, key, wrapperLanda((v, k) -> System.out.println(v / k)));

        key = 0;
        System.out.println("Lambda for with a wrapper with Exception Handler (returns itself) KEY = 0");
        //Lambda for with a wrapper with Exception Handler (returns itself) KEY = 0
        process(someNumbers, key, wrapperLanda((v, k) -> System.out.println(v / k)));

    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i: someNumbers) {
            consumer.accept(i, key);
        }
    }

      // Executes normal Lambda
//    private static BiConsumer<Integer, Integer> wrapperLanda(BiConsumer<Integer, Integer> consumer) {
//        return consumer;
//    }

    // Executes override wrapper to add instead
//    private static BiConsumer<Integer, Integer> wrapperLanda(BiConsumer<Integer, Integer> consumer) {
//        return (v, k) -> System.out.println(v + k);
//    }

    // Executes new Lambda Expression to do what the Consumer asks
    // TODO Make this function accept generics not integers - assignment?
    private static BiConsumer<Integer, Integer> wrapperLanda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("Wrapper Caught ArithmeticException Exception");
            }
        };
    }

    private static BiConsumer<Object, Object> wrapperGenericLanda(BiConsumer<Object, Object> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("Wrapper Caught ArithmeticException Exception");
            }
        };
    }

}

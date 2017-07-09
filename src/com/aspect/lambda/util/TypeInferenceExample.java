package com.aspect.lambda.util;

/**
 * Created by Ruaidhri on 02/07/2017.
 *
 * Compiler is inferring what the input argument and return type is
 */
public class TypeInferenceExample {

    public static void main(String[] args) {
        printLambda(s -> s.length());
    }

    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength("Hello Lambda"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }

}

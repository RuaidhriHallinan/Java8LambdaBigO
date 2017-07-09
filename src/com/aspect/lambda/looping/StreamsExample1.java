package com.aspect.lambda.looping;

import com.aspect.lambda.exercises.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class StreamsExample1 {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person( "Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        people.stream() //creates a conveyor belt
        .filter(p -> p.getLastName().startsWith("C")) //Filters by Last Name beginning with C
        .forEach(p -> System.out.println(p.getFirstName())); //Loops and Prints their First Name

    }

}

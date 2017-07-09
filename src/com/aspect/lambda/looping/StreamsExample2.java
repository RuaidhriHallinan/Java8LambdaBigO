package com.aspect.lambda.looping;

import com.aspect.lambda.exercises.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class StreamsExample2 {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person( "Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //Get a count of people who's last name starts with C
        long count = people.stream()
                    .filter(p -> p.getLastName().startsWith("C"))
                    .count();
        System.out.println("Number of people who's last name begins with 'C' is " + count);

        long parallelCount = people.parallelStream()
                .filter(p -> p.getLastName().startsWith("C"))
                .count();
    }
}

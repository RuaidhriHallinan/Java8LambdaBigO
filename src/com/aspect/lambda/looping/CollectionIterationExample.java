package com.aspect.lambda.looping;

import com.aspect.lambda.exercises.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person( "Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        System.out.println("Using a for loop");

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println("Using interater (for in) of loop");

        for (Person p: people) {
            System.out.println(p);
        }

        System.out.println("Using Lambda Expression loop");
        //people.forEach( (p) -> System.out.println(p));
        people.forEach(p -> System.out.println(p));


        System.out.println("Using Lambda Expression loop and Method Reference");
        people.forEach(System.out::println);
    }


}

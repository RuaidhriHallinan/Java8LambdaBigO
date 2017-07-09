package com.aspect.lambda.methodReference;

import com.aspect.lambda.exercises.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Ruaidhri on 03/07/2017.
 */
public class MethodReferenceExample2Functions {


    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person( "Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        System.out.println("Now sorting by Last Name");

        // Step 1 : Sort list by last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2 : Create a method that prints all elements in the list
        System.out.println("Now printing all persons...");

        //Using a method reference
        performConditionally(people, p -> true, System.out::println ); // p -> method(p)

    }

    public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p: people ) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }

    }

}

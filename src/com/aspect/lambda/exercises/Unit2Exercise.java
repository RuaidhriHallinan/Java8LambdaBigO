package com.aspect.lambda.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// You can use Interfaces in the function package for your Lambda Expression

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class Unit2Exercise {

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
        //IFunctionalPerson lambdaSort = () -> people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        //lambdaSort.funct();
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2 : Create a method that prints all elements in the list
        //IFunctionalPerson lambdaPrint = () -> people.forEach(System.out::println);
        //lambdaPrint.funct();
        System.out.println("Now printing all persons...");

        performConditionally(people, p -> true, p -> System.out.println(p));

        System.out.println("Now printing each if last name ending with 'C'...");

        // Step 3 : Create a method that prints all people that have a last name beginning with C
        //IFunctionalPerson lambdaStartC = () -> people.forEach(item -> {
        //    if(item.getLastName().startsWith("C")){
        //        System.out.println(item.toString());
        //    }
        //});
        //lambdaStartC.funct();

        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));

        System.out.println("Now printing each if first name ending with 'C'...");

        performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
    }

    public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p: people ) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }

    }

}

package com.aspect.lambda.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class Unit1Exercise {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person( "Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        //Iterate through people
        for (Person per: people) {
            //Print list of ID's with Timestamps
            System.out.println(per.toString());
        }

        System.out.println("Now sorting by First Name");

        // Step 1 : Sort list by last name
        //IFunctionalPerson lambdaSort = () -> people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        //lambdaSort.funct();
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2 : Create a method that prints all elements in the list
        //IFunctionalPerson lambdaPrint = () -> people.forEach(System.out::println);
        //lambdaPrint.funct();
        System.out.println("Now printing all persons...");
        printConditionally(people, p -> true);

        System.out.println("Now printing each if last name ending with 'C'...");

        // Step 3 : Create a method that prints all people that have a last name beginning with C
        //IFunctionalPerson lambdaStartC = () -> people.forEach(item -> {
        //    if(item.getLastName().startsWith("C")){
        //        System.out.println(item.toString());
        //    }
        //});
        //lambdaStartC.funct();

        printConditionally(people, p -> p.getFirstName().startsWith("C"));
    }

    public static void printConditionally(List<Person> people, Condition condition) {
        for (Person p: people ) {
            if(condition.test(p)) {
                System.out.println(p);
            }
        }

    }

}

interface Condition {
    boolean test(Person p);
}

package com.aspect.lambda.exercises;

/**
 * Created by Ruaidhri on 02/07/2017.
 */
public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Overriding the toString representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Person [First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age;
    }

    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.lastName);
    }

}

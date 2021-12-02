package com.akadatsky;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = PersonFactory.generatePersons();
        for (Person person : people) {
            System.out.println(person);
        }
    }

}

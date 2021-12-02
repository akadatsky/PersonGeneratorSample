package com.akadatsky;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonFactory {

    public static final int PERSON_COUNT = 100;
    private static final Random RANDOM = new Random();

    private static final String[] NAMES = {"Alex", "Ben", "Carl"};
    private static final String[] LAST_NAMES = {"Alexov", "Benov", "Carlov"};
    public static final int MAX_AGE = 100;
    public static final int MAX_HEIGHT = 200;
    public static final int MIN_WEIGHT = 3;
    public static final int MAX_WEIGHT = 120;

    public static List<Person> generatePersons() {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < PERSON_COUNT; i++) {
            Person person = generateRandomPerson();
            result.add(person);
        }
        return result;
    }

    private static Person generateRandomPerson() {
        String firstName = NAMES[RANDOM.nextInt(NAMES.length)];
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        int age = RANDOM.nextInt(MAX_AGE);

        double weight = RANDOM.nextDouble() * (MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT;
        int height = RANDOM.nextInt(MAX_HEIGHT);

        if (age < 7) {
            height = RANDOM.nextInt(100);
            weight = RANDOM.nextDouble() * (20 - MIN_WEIGHT) + MIN_WEIGHT;
        } else if (age < 14) {
            height = RANDOM.nextInt(100) + 50;
            weight = RANDOM.nextDouble() * (80 - 20) + 20;
        }

        return new Person(firstName, lastName, age, round(weight, 2), height);
    }

    private static int generateRandomHeight(int from, int to) {
        return 0;
    }

    private static double generateRandomWeight(double from, double to) {
        return 0;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

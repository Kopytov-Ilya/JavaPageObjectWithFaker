package tests;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;

public class TestData {

    Faker faker = new Faker();

    String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.number().numberBetween(1000000000L, 9999999999L) + "",
            subject = setRandomValue("Computer Science", "Arts", "Civics", "Physics"),
            gender = setRandomValue("Male", "Female", "Other"),
            day = setRandomDay(),
            month = setRandomValue("January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"),
            year = faker.number().numberBetween(1900, 2023) + "",
            hobby = setRandomValue("Sports", "Reading", "Music"),
            picture = "ForTest.png",
            address = faker.address().streetAddress(),
            state = setRandomValue("Uttar Pradesh", "NCR", "Haryana", "Rajasthan"),
            city = setRandomCity(state),
            negativeName = "Test2";

    public String setRandomValue(String... strings) {
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, strings);
        String item = values.get(faker.random().nextInt(0, values.size() - 1));
        return item;
    }

    public String setRandomDay() {
        int day = faker.number().numberBetween(1, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return day + "";
        }
    }

    public String setRandomCity(String state) {
        String item = null;
        ArrayList<String> values = new ArrayList<>();
        if (state.equals("NCR")) {
            Collections.addAll(values, "Delhi", "Gurgaon", "Noida");
            item = values.get(faker.random().nextInt(0, values.size() - 1));
        } else if (state.equals("Uttar Pradesh")) {
            Collections.addAll(values, "Agra", "Lucknow", "Merrut");
            item = values.get(faker.random().nextInt(0, values.size() - 1));
        } else if (state.equals("Haryana")) {
            Collections.addAll(values, "Karnal", "Panipat");
            item = values.get(faker.random().nextInt(0, values.size() - 1));
        } else if (state.equals("Rajasthan")) {
            Collections.addAll(values, "Jaipur", "Jaiselmer");
            item = values.get(faker.random().nextInt(0, values.size() - 1));
        }
        return item;
    }
}

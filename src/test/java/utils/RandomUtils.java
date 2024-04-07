package utils;


import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en-GB"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getRandomStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getRandomMobile() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String[] getRandomSubjects() {
        return faker.options().option("Math", "Biology", "English").split(" ");
    }

    public String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomPictureAddress() {
        return faker.options().option("img/1.jpg", "img/2.jpg", "img/3.jpg");
    }

    public Date getRandomDateOfBirth() {
        return faker.date().birthday();
    }

    public String getRandomState() {

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajastan");
    }

    public String getRandomCity(String state) {

        String city = "";

        if (state.equals("NCR"))
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh"))
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana"))
            city = faker.options().option("Karnal", "Panipat");
        else if (state.equals("Rajasthan"))
            city = faker.options().option("Jaipur", "Jaiselmer");

        return city;
    }
}

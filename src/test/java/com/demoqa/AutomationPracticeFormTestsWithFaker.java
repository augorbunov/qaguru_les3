package com.demoqa;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import utils.RandomUtils;

public class AutomationPracticeFormTestsWithFaker extends TestBase {
    RandomUtils randomUtils = new RandomUtils();

    String firstName, lastName, userEmail, streetAddress,
            gender, mobile, hobbies, pictureAddress, pictureName, dayOfBirth, monthOfBirth, yearOfBirth,
            city, state;

    Date dateOfBirth;
    String[] subjects;
    String[] tmp;

    @Test
    //test filling all fields on the form
    void fillFullFormTest() {

        firstName = randomUtils.getRandomFirstName();
        lastName = randomUtils.getRandomLastName();
        userEmail = randomUtils.getEmailAddress();
        streetAddress = randomUtils.getRandomStreetAddress();
        gender = randomUtils.getRandomGender();
        mobile = randomUtils.getRandomMobile();
        subjects = randomUtils.getRandomSubjects();
        hobbies = randomUtils.getRandomHobby();

        pictureAddress = randomUtils.getRandomPictureAddress();
        tmp = pictureAddress.split("/");
        pictureName = tmp[tmp.length-1];

        dateOfBirth = randomUtils.getRandomDateOfBirth();
        monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(dateOfBirth);
        dayOfBirth = new SimpleDateFormat("d").format(dateOfBirth);
        yearOfBirth = new SimpleDateFormat("YYYY").format(dateOfBirth);

        state = randomUtils.getRandomState();
        city = randomUtils.getRandomCity(state);

//        System.out.println(String.format("%s %s %s",dayOfBirth, monthOfBirth, yearOfBirth));

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(pictureAddress)
                .setAddress(streetAddress)
                .setStateAndCity(state, city)
                .submitForm();

        //check results
        registrationPage.checkResultPositive()
                .checkResult("Student Name", String.format("%s %s", firstName, lastName))
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", String.format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth))
                .checkResult("Address", streetAddress)
                .checkResult("Subjects", subjects[0])
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("State and City", String.format("%s %s", state, city));

    }

    @Test
    //test filling only required fields
    void fillRequiredFieldsFormTest() {

        firstName = randomUtils.getRandomFirstName();
        lastName = randomUtils.getRandomLastName();
        gender = randomUtils.getRandomGender();
        mobile = randomUtils.getRandomMobile();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(mobile)
                .submitForm();

        //check results
        registrationPage.checkResultPositive()
                .checkResult("Student Name", String.format("%s %s", firstName, lastName))
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    @Test
    //test negative asserts
    void negativeFormTest() {

        firstName = randomUtils.getRandomFirstName();
        lastName = randomUtils.getRandomLastName();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .submitForm();

        //check results
        registrationPage.checkResultNegative();
    }
}

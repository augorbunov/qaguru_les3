package com.demoqa;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTestsWithPageObject extends TestBase {

    @Test
    //test filling all fields on the form
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Surname")
                .setEmail("test@email.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("29", "May", "1990")
                .setSubjects(new String[]{"Math", "Biology"})
                .setHobbies("Sports")
                .uploadPicture("img/1.jpg")
                .setAddress("Address st. 1 apt.123")
                .setStateAndCity("Haryana", "Karnal")
                .submitForm();

        //check results
        registrationPage.checkResultPositive()
                .checkResult("Student Name", "Name Surname")
                .checkResult("Student Email", "test@email.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "29 May,1990");

    }

    @Test
    //test filling only required fields
    void fillRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Surname")
                .setGender("Other")
                .setUserNumber("1234567890")
                .submitForm();

        //check results
        registrationPage.checkResultPositive()
                .checkResult("Student Name", "Name Surname")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890");
    }

    @Test
    //test negative asserts
    void negativeFormTest() {
        registrationPage.openPage()
                .setFirstName("Name")
                .setLastName("Surname")
                .submitForm();

        //check results
        registrationPage.checkResultNegative();
    }
}

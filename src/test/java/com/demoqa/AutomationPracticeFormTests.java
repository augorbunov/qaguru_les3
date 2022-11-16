package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void SetUp () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {
        open("/automation-practice-form");

        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("test@email.com");

        $("#firstName").equals("Name");
        $("#lastName").equals("Surname");
        $("#userEmail").equals("test@email.com");
    }

    /*@Test
    void fillWrongEmailTest () {
        open("/automation-practice-form");

        $("#userEmail").setValue("testemail.com");
    }*/
}

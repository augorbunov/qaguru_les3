package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void setUp () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        //check that the page has been loaded
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //remove useless elements from the page
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //filling values
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("test@email.com");
        //click radio button
        //$("#gender-radio-1").parent().click();
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");

        //input date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--029:not(react-datepicker__day--outside-month)").click();

        //input subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        //$("#subjectsInput").sendKeys("Maths");
        //$("#subjectsInput").pressEnter();

        //hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //upload picture
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.jpg"));

        $("#currentAddress").setValue("Address st. 1 apt.123");

        //select state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //submit form
        $("#submit").click();


        //check filled values
        $(".modal-dialog").should(appear);

        $(".table-responsive").shouldHave(text("Name"),text("Surname"),
                text("Maths"),text("Karnal"));
        //check a separate row
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Address st. 1 apt.123"));
    }

}

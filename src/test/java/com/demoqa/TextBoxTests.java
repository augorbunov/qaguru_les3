package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void SetUp () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {
        open("/text-box");
        $("[id=userName]").setValue("Egor");
        $("[id=userEmail]").setValue("Egor@test.com");
        $("[id=currentAddress]").setValue("current address");
        $("[id=permanentAddress]").setValue("permanent address");
        $("[id=submit]").click();

        $("#output").shouldHave(text("Egor"));
        $("#output #name").shouldHave(text("Egor"));
        $("#output #email").shouldHave(text("Egor"));
    }
}

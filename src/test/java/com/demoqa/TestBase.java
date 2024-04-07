package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

    public class TestBase {

        RegistrationPage registrationPage = new RegistrationPage();

        @BeforeAll
        static void setUp () {
            Configuration.baseUrl = "https://demoqa.com";
            //Configuration.holdBrowserOpen = true;
            //Configuration.browser = "chrome";
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
        }

    }


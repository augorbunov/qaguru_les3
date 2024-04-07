package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            cityStateWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),

            resultHeader = $("[class]");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String[] strArray) {
        for (String str : strArray) {
            userSubjectsInput.setValue(str).pressEnter();
        }

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        userHobbiesInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        cityStateWrapper.$(byText(state)).click();
        cityInput.click();
        cityStateWrapper.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }

    public RegistrationPage checkResultPositive() {
        resultHeader.shouldHave((text("Thanks for submitting the form")));

        return this;
    }
    public RegistrationPage checkResultNegative() {
        resultHeader.shouldNotHave((text("Thanks for submitting the form")));

        return this;
    }
}

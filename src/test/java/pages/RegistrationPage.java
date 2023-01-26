package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultPopUp;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultPopUp resultPopUp = new ResultPopUp();

    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderOption = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            dateSelect = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            uploadImage = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCity = $("#stateCity-wrapper"),
            stateField = $("#state"),
            cityField = $("#city"),
            submitButton = $("#submit"),
            popup = $(".modal-content");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

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

    public RegistrationPage userEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderOption.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateSelect.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesSelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadImage.uploadFromClasspath("img/" + value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyModalAppears() {
        resultPopUp.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        resultPopUp.verifyResults(key, value);

        return this;
    }

    public RegistrationPage verifyNotAppears() {
        popup.shouldNotBe(visible);

        return this;
    }
}

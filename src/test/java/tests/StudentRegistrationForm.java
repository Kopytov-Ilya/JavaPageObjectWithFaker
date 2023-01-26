package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

    @Test
    @DisplayName("Успешное заполнение формы")
    void successfulFilledForm() {

        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .userEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()

                .verifyModalAppears()
                .verifyResults("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResults("Student Email", testData.email)
                .verifyResults("Gender", testData.gender)
                .verifyResults("Mobile", testData.phoneNumber)
                .verifyResults("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .verifyResults("Subjects", testData.subject)
                .verifyResults("Hobbies", testData.hobby)
                .verifyResults("Picture", testData.picture)
                .verifyResults("Address", testData.address)
                .verifyResults("State and City", testData.state + " " + testData.city);
    }


    @Test
    @DisplayName("Некорректное заполнение формы")
    void unsuccessfulFilledForm() {

        String negativeName = "Test2";
        registrationPage
                .openPage()
                .setFirstName(negativeName)
                .submit()
                .verifyNotAppears();
    }
}

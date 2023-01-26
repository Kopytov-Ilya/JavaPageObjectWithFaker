package tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

    @Test
    void successfulFilledForm() {
        String
                firstName = "Test",
                lastName = "Testov",
                email = "Test@mail.ru",
                phoneNumber = "1234567890",
                subject = "Computer Science",
                gender = "Male",
                day = "18",
                month = "February",
                year = "1994",
                hobby = "Sports",
                picture = "ForTest.png",
                address = "Test Federation, TestTown",
                state = "NCR",
                city = "Delhi";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .userEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", picture)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);
    }


    @Test
    void unsuccessfulFilledForm() {

        String negativeName = "Test2";
        registrationPage
                .openPage()
                .setFirstName(negativeName)
                .submit()
                .verifyNotAppears();
    }
}

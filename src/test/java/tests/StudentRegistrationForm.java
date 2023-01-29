package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationForm extends TestBase {

    @Test
    @Feature("Форма анкетирования")
    @Story("Заполнение формы")
    @Owner("Kopytov-Ilya")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Успешное заполнение формы")

    public void successfulFilledForm() {

        step("Открываем страницу с формой", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя " + testData.firstName, () -> {
            registrationPage.setFirstName(testData.firstName);
        });

        step("Вводим фамилию " + testData.lastName, () -> {
            registrationPage.setLastName(testData.lastName);
        });

        step("Вводим email адрес " + testData.email, () -> {
            registrationPage.userEmail(testData.email);
        });

        step("Выбираем пол " + testData.gender, () -> {
            registrationPage.setGender(testData.gender);
        });

        step("Вводим тефонный номер " + testData.phoneNumber, () -> {
            registrationPage.setPhoneNumber(testData.phoneNumber);
        });

        step("Выбираем дату рождения " + testData.day + " " + testData.month + " " + testData.year, () -> {
            registrationPage.setBirthDate(testData.day, testData.month, testData.year);
        });

        step("Вводим в поле субъект " + testData.subject, () -> {
            registrationPage.setSubject(testData.subject);
        });

        step("Выбираем в качестве хобби " + testData.hobby, () -> {
            registrationPage.setHobbies(testData.hobby);
        });

        step("Загружаем файл " + testData.picture, () -> {
            registrationPage.uploadPicture(testData.picture);
        });

        step("Вводим адрес " + testData.address, () -> {
            registrationPage.setAddress(testData.address);
        });

        step("Выбираем регион " + testData.state, () -> {
            registrationPage.setState(testData.state);
        });

        step("Выбираем город " + testData.city, () -> {
            registrationPage.setCity(testData.city);
        });

        step("Подтверждаем введенные данные", () -> {
            registrationPage.submit();
        });


        step("Проверяем, что модальное окно с заполненной анкетой появилось", () -> {
            registrationPage.verifyModalAppears();
        });

        step("Проверяем, что имя и фамилия в анкете - " + testData.firstName + " " + testData.lastName, () -> {
            registrationPage.verifyResults("Student Name", testData.firstName + " " + testData.lastName);
        });

        step("Проверяем, что email в анкете - " + testData.email, () -> {
            registrationPage.verifyResults("Student Email", testData.email);
        });

        step("Проверяем, что пол выбран -  " + testData.gender, () -> {
            registrationPage.verifyResults("Gender", testData.gender);
        });

        step("Проверяем, что номер телефона указан - " + testData.phoneNumber, () -> {
            registrationPage.verifyResults("Mobile", testData.phoneNumber);
        });

        step("Проверяем, что дата рождения - " + testData.day + " " + testData.month + "," + testData.year, () -> {
            registrationPage.verifyResults("Date of Birth", testData.day + " " + testData.month + "," + testData.year);
        });

        step("Проверяем, что в поле субъекта введено - " + testData.subject, () -> {
            registrationPage.verifyResults("Subjects", testData.subject);
        });

        step("Проверяем, что выбрано хобби - " + testData.hobby, () -> {
            registrationPage.verifyResults("Hobbies", testData.hobby);
        });

        step("Проверяем, что загружен файл - " + testData.picture, () -> {
            registrationPage.verifyResults("Picture", testData.picture);
        });

        step("Проверяем, что указанный адрес - " + testData.address, () -> {
            registrationPage.verifyResults("Address", testData.address);
        });

        step("Проверяем, что выбранные регион и город - " + testData.state + " " + testData.city, () -> {
            registrationPage.verifyResults("State and City", testData.state + " " + testData.city);
        });
    }


    @Test
    @Feature("Форма анкетирования")
    @Story("Заполнение формы")
    @Owner("Kopytov-Ilya")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "Demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Некорректное заполнение формы")
    void unsuccessfulFilledForm() {


        step("Открываем страницу с формой", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя " + testData.negativeName, () -> {
            registrationPage.setFirstName(testData.negativeName);
        });

        step("Подтверждаем введенные данные", () -> {
            registrationPage.submit();
        });

        step("Проверяем, что модальное окно с результами не появилось", () -> {
            registrationPage.verifyNotAppears();
        });
    }
}

package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestConfiguration;

import static com.codeborne.selenide.Selenide.*;

@Tag("fillForm")
@DisplayName("Тесты для формы регистрации https://demoqa.com/automation-practice-form")
class RegistrationWithPageObjectsTests extends TestConfiguration {
    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Заполнение формы регистрации с полным набором параметров")
    @Test
    void checkFormTest() {
        open("/automation-practice-form");

        registrationPage.openPage()
                        .setFirstName("Alex")
                        .setLastName("Ruby")
                        .setUserEmail("alex@gmail.com")
                        .setGender("Male")
                        .setNumber("1234567898")
                        .setDate("25", "June", "1990")
                        .setSubjects("Arts")
                        .setHobbies("Sports")
                        .loadPicture("images.jfif")
                        .setCurrentAdress("Street Main")
                        .setState("NCR")
                        .setCity("Delhi")
                        .setSubmit();

        registrationPage.verifyRegistrationModalAppears()
                .verifyResult("Student Name", "Alex Ruby")
                .verifyResult("Student Email", "alex@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567898")
                .verifyResult("Date of Birth", "25 June,1990")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "Images.jfif")
                .verifyResult("Address", "Street Main")
                .verifyResult("State and City", "NCR Delhi");
    }
}

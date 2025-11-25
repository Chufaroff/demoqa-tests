package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestConfiguration;

import static com.codeborne.selenide.Selenide.*;


class RegistrationWithPageObjectsTests extends TestConfiguration {
    RegistrationPage registrationPage = new RegistrationPage();

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
                        .loadPicture("Images.jfif")
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

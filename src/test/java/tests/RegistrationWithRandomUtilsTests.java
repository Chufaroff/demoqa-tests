package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestConfiguration;
import utils.RegistrationRandomUtils;

import static com.codeborne.selenide.Selenide.open;

class RegistrationWithRandomUtilsTests extends TestConfiguration {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void checkFormTestWithRandomUtils() {

        // Создаем экземпляр RegistrationRandomUtils
        RegistrationRandomUtils randomUtils = new RegistrationRandomUtils();

        // Генерируем тестовые данные
        String firstName = randomUtils.generateFirstName();
        String lastName = randomUtils.generateLastName();
        String email = randomUtils.generateEmail();
        String gender = randomUtils.generateGender();
        String numberPhone = randomUtils.generatePhoneNumber();
        String day = randomUtils.generateDay();
        String month = randomUtils.generateMonth();
        String year = randomUtils.generateYear();
        String dateOfBirth = day + " " + month + "," + year;
        String subject = randomUtils.generateSubjects();
        String hobby = randomUtils.generateHobbies();
        String picture = randomUtils.generatePicture();
        String address = randomUtils.generateAddress();
        // Генерируем связанные штат и город (БЕЗ ИНДЕКСОВ!)
        String state = randomUtils.generateState();
        String city = randomUtils.generateCity(state);


        open("/automation-practice-form");

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender(gender)
                        .setNumber(numberPhone)
                        .setDate(day, month, year)
                        .setSubjects(subject)
                        .setHobbies(hobby)
                        .loadPicture(picture)
                        .setCurrentAdress(address)
                        .setState(state)
                        .setCity(city)
                        .setSubmit();

        registrationPage.verifyRegistrationModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", numberPhone)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}

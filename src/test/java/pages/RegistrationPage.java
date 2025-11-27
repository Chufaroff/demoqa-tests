package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateClick = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityClick = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    @Step("Открытие главной страницы регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Ввод имени {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Ввод фамилии {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Ввод почты {email}")
    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    @Step("Выбор пола {gender}")
    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    @Step("Ввод номера телефона {phoneNumber}")
    public RegistrationPage setNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);

        return this;
    }

    @Step("Выбор даты рождения {day}.{month}.{year}")
    public RegistrationPage setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбор предметов {subjects}")
    public RegistrationPage setSubjects(String subjects) {
        userSubjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    @Step("Выбор увлечений {hobby}")
    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    @Step("Загрузка фотографии {picture}")
    public RegistrationPage loadPicture (String picture) {
        uploadPicture.uploadFromClasspath(picture);

        return this;
    }

    @Step("Ввод текущего адреса {adress}")
    public RegistrationPage setCurrentAdress (String adress) {
        currentAddress.setValue(adress).scrollTo();

        return this;
    }

    @Step("Выбор штата из выпадающего списка {state}")
    public RegistrationPage setState (String state) {
        stateClick.click();
        stateInput.$(byText(state)).click();

        return this;
    }

    @Step("Выбор города из выпадающего списка {city}")
    public RegistrationPage setCity (String city) {
        cityClick.click();
        cityInput.$(byText(city)).click();

        return this;
    }

    @Step("Нажатие кнопки Submit при завершении регистрации")
    public RegistrationPage setSubmit () {
        submitButton.click();

        return this;
    }

    @Step("Проверка появления модального окна об успешной регистрации")
    public RegistrationPage verifyRegistrationModalAppears () {
        resultsModal.verifyModalAppears ();

        return this;
    }

    @Step("Проверка полей результирующей таблицы {key} : {value}")
    public RegistrationPage verifyResult (String key, String value) {
        resultsModal.verifyResults(key, value);

        return this;
    }
}

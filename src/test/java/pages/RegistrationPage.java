package pages;

import com.codeborne.selenide.SelenideElement;
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
            gender = $("#genterWrapper"),
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

    public RegistrationPage openPage() {
        open("/automation-practice-form");

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

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        userSubjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage loadPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAdress (String value) {
        currentAddress.setValue(value).scrollTo();

        return this;
    }

    public RegistrationPage setState (String value) {
        stateClick.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        cityClick.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubmit () {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyRegistrationModalAppears () {
        resultsModal.verifyModalAppears ();

        return this;
    }

    public RegistrationPage verifyResult (String key, String value) {
        resultsModal.verifyResults(key, value);

        return this;
    }
}

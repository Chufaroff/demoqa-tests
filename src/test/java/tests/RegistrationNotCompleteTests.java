package tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import pages.TestConfiguration;
import pages.helpers.Attachments;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Chufarov Bogdan")
@Severity(SeverityLevel.NORMAL)
class RegistrationNotCompleteTests extends TestConfiguration {

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }

    @Test
    @Link(name = "Testing", url = "https://demoqa.com")
    @DisplayName("Форма регистрации на сайте")
    @Tag("demoqa")
    void checkFormTest() {

        step("Open registration form", () -> {
            open("/automation-practice-form");
            Attachments.screenshotAs("Form opened");
        });

        step("Fill form and press the button Submit", () -> {

            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Ruby");
            $("#userEmail").setValue("alex@gmail.com");
            $("#genterWrapper").$(byText("Male")).click();
            //$("[for=gender-radio-1]").click();
            //$("#gender-radio-1").parent().click();
            $("#userNumber").setValue("1234567898");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("June");
            //$(".react-datepicker__month-select").selectOptionByValue("5");
            $(".react-datepicker__year-select").selectOption("1990");
            //$(".react-datepicker__year-select").selectOptionByValue("1990");
            $(".react-datepicker__day--025").click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("images.jfif");
            $("#currentAddress").setValue("Street Main").scrollTo();
            $("#state").click();
            $(byText("NCR")).click();
            $("#city").click();
            $(byText("Delhi")).click();
            $("#submit").click();
            Attachments.pageSource();
        });

        step("Verify results registration", () -> {
            $(".modal-content").shouldBe(visible);
            $(".table-responsive").shouldBe(visible);
            $(".table-responsive").shouldHave(text("Alex"), text("Ruby"), text("alex@gmail.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("1234567898"));
            $(".table-responsive").shouldHave(text("25 June,1990"));
            $(".table-responsive").shouldHave(text("Arts"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("Images.jfif"));
            $(".table-responsive").shouldHave(text("Street Main"));
            $(".table-responsive").shouldHave(text("NCR Delhi"));
            Attachments.browserConsoleLogs();
        });
    }
}

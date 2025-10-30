package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @AfterAll
    static void closeBrowser() {
            closeWebDriver();
    }

    @Test
    void checkFormTest() {
        open("/automation-practice-form");


        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ruby");
        $("#userEmail").setValue("alex@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567898");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Images.jfif");
        $("#currentAddress").setValue("Street Main").scrollTo();
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldBe(visible);

        $(".table-responsive").shouldHave(text("Alex Ruby"));
        $(".table-responsive").shouldHave(text("alex@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567898"));
        $(".table-responsive").shouldHave(text("25 June,1990"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Images.jfif"));
        $(".table-responsive").shouldHave(text("Street Main"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}

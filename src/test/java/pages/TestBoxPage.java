package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxPage {

    SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddres = $("#currentAddress"),
            userPermanentAddres = $("#permanentAddress"),
            buttonSubmit = $("#submit");


    public TestBoxPage openTestBoxPage() {
        open("/text-box");
        return this;
    }

    public TestBoxPage setUserName(String name) {
        userName.setValue(name);
        return this;
    }

    public TestBoxPage setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public TestBoxPage setCurrentAddress(String firstAddress) {
        userCurrentAddres.setValue(firstAddress);
        return this;
    }

    public TestBoxPage setPermanentAddress(String secondAddress) {
        userPermanentAddres.setValue(secondAddress);
        return this;
    }

    public TestBoxPage clickButtonSubmit() {
        buttonSubmit.scrollTo().click();
        return this;
    }

    public TestBoxPage checkResult(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}

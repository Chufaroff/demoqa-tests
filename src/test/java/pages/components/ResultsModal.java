package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {

    public void verifyModalAppears () {
        $(".modal-content").shouldBe(visible);
    }

    public void verifyResults (String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
    }
}

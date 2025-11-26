package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import pages.helpers.Attachments;

public class TestBaseWithAttachments extends TestConfiguration {

    @AfterEach
    void addAttachments() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            Attachments.screenshotAs("Last Screenshot");
            Attachments.pageSource();
            Attachments.browserConsoleLogs();
            Attachments.addVideo();
        }

        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }
}

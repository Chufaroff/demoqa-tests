package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.helpers.Attachments;

import java.util.Map;

@ExtendWith({BrowserPerTestStrategyExtension.class})
public class TestConfiguration {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        // Настройка Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true)
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        // Сохраняем скриншот, исходный код и логи после каждого теста
        if (WebDriverRunner.hasWebDriverStarted()) {
            Attachments.screenshotAs("Screenshot after test: " + testInfo.getDisplayName());
            Attachments.pageSource();
            Attachments.browserConsoleLogs();

            // Если используется Selenoid - добавляем видео
            if (Configuration.remote != null) {
                Attachments.addVideo();
            }
        }

        Selenide.closeWebDriver();
    }
}

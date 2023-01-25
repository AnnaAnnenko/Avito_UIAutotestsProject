package avito.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import avito.drivers.WebDriverProvider;
import avito.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        WebDriverProvider.configure();
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }
    @AfterEach
    void Attachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

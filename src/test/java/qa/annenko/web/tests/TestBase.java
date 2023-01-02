package qa.annenko.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.annenko.helpers.Attach;

public class TestBase {

//    @BeforeAll
//    static void setUp() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        Configuration.browserCapabilities = capabilities;
//        Configuration.baseUrl = "https://";
//        Configuration.browser = Properties.browser();
//        Configuration.browserVersion  = Properties.browserVersion();
//        Configuration.browserSize = Properties.screenSize();
//        if (!Properties.remoteBrowser().equals("")) {
//            Configuration.remote = Properties.remoteBrowser();
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//        }
//    }

    @AfterEach
    void Attachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

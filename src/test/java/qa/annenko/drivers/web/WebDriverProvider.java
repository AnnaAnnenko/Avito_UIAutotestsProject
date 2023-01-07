package qa.annenko.drivers.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.annenko.config.web.WebDriverConfig;

public class WebDriverProvider {

    static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static void configure() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        String remoteUrl = webConfig.getRemoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }
}
package avito.drivers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import avito.config.WebDriverConfig;

public class WebDriverProvider {
    static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static void configure() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        String remoteUrl = webConfig.remoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }
}
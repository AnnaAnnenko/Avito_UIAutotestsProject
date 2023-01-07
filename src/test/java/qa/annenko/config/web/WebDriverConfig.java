package qa.annenko.config.web;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})

public interface WebDriverConfig extends Config{

    @Key("baseUrl")
    @DefaultValue("https://www.avito.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();
}

package avito.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${environment}.properties"})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.avito.ru")
    String baseUrl();
    @Key("browser")
    @DefaultValue("chrome")
    String browser();
    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();
    @Key("remoteUrl")
    String remoteUrl();
}

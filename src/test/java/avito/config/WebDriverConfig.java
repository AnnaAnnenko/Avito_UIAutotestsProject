package avito.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${environment}.properties"})

public interface WebDriverConfig extends Config {

    @DefaultValue("https://www.avito.ru")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("99")
    String browserVersion();
    String remoteUrl();
}

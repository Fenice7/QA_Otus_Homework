package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("otusUrl")
    String otusUrl();

    @Key("yandexMarket")
    String yandexMarket();

    @Key("otusLkAbout")
    String otusLkAbout();

    @Key("email")
    String email();

    @Key("psw")
    String psw();

}

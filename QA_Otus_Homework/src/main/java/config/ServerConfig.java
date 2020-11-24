package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url")
    String url();

    @Key("yandexMarket")
    String yandexMarket();

    @Key("skills")
    String skills();
    @Key("email")
    String email();
    @Key("psw")
    String psw();

}

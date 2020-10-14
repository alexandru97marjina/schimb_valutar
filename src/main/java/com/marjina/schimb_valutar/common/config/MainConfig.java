package com.marjina.schimb_valutar.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:main.properties")
public class MainConfig {

    public static final String LANG = "en";

    /**
     * Secret key used for security purposes
     */
    @Value("${authentication.secret:ookgroup}")
    private String secret;

    /**
     * Defines time interval in milliseconds after which the token will expire
     */
    @Value("${token.expire.interval:2000}")
    private Long tokenExpireInterval;

}

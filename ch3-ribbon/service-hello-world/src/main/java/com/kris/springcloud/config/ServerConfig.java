package com.kris.springcloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kairou Zeng on 2017/8/16.
 */
@Configuration
@ConfigurationProperties("server")
@Data
public class ServerConfig {

    private String port;
}

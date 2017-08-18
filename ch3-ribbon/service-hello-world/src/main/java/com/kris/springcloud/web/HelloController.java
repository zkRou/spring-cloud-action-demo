package com.kris.springcloud.web;

import com.kris.springcloud.config.ServerConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Kairou Zeng on 2017/8/16.
 */
@RestController
@AllArgsConstructor
public class HelloController {

    private final ServerConfig config;

    @GetMapping("/hello-world")
    public String index(){
        return "Hello world,port:" + config.getPort();

    }
}

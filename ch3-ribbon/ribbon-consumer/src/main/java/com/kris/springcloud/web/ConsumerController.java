package com.kris.springcloud.web;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kairou Zeng on 2017/8/17.
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://service-hello-world/hello-world", String.class).getBody();
    }

    @GetMapping("/name-consumer/{name}")
    public String nameConsumer(@PathVariable("name")String name){
        return restTemplate.getForEntity("http://service-hello-world/hello?name={1}", String.class, name).getBody();
    }

    @GetMapping("/map-consumer/{name}")
    public String mapConsumer(@PathVariable("name")String name){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return restTemplate.getForEntity("http://service-hello-world/hello/{name}", String.class, map).getBody();
    }

    @GetMapping("/uri-consumer/{name}")
    public String uriConsumer(@PathVariable("name")String name){
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://service-hello-world/hello/{name}")
                .build()
                .expand(name)
                .encode().toUri();
        return restTemplate.getForEntity(uri, String.class).getBody();
    }

    @GetMapping("/object-consumer/{name}")
    public String objectConsumer(@PathVariable("name")String name){
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://service-hello-world/hello/{name}")
                .build()
                .expand(name)
                .encode().toUri();
        return restTemplate.getForObject(uri, String.class);
    }
}

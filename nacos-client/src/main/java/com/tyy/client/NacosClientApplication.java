package com.tyy.client;

import com.tyy.client.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }

    @Value("${age}")
    private Integer age;
    @Value("${name}")
    private String name;
    @Value("${address}")
    private String address;


    @GetMapping("/test")
    public String testConfig() {
        return new User(name, age, address).toString();
    }
}

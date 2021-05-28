package com.springcloud.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaclientApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EurekaclientApplication.class, args);
        new SpringApplicationBuilder(
                EurekaclientApplication.class)
                .web(true).run(args);
    }

}

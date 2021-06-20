package com.example.eurekaconsumer.configuration;

import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;

@Configuration
public class FileConfig {

    @Bean
    public Encoder feignFormEncoder(){
        return new SpringFormEncoder();
    }
}

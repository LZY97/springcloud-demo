package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;
//    @Autowired
//    RestTemplate restTemplate;


    @Autowired
    DcClient dcClient;
    @GetMapping("/consumer")
    public String dc(){
//        ServiceInstance eurekaClient = loadBalancerClient.choose("eureka-client");
//        String url = "http://" + eurekaClient.getHost() + ":" + eurekaClient.getPort() + "/dc";
//        System.out.println(url);
//        return restTemplate.getForObject(url, String.class);
//        return restTemplate.getForObject("http://eureka-client/dc",String.class);
        return dcClient.consumer();
    }
}

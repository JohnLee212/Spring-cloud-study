package com.example.alibabanacosdiscoveryserver.controller;

import feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

  /*  @Resource
    RestTemplate restTemplate;*/

    @Resource
    private Client client;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }

   /* @GetMapping("/test")
    public String test() {
        String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=didi", String.class);
        return "Return : " + result;
    }*/



    @GetMapping("/test")
    public String test() {
//        String result = client;
        return "Return : " + "";
    }
}

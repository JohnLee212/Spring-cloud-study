package com.example.servicemiya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 链路追踪
 * @date 2020/6/319:55
 */
@RestController
@Slf4j
public class MiyaController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(){
        log.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        log.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }
}

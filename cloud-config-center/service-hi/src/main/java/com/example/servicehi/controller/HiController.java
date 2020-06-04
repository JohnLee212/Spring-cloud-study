package com.example.servicehi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 测试cloud链路跟踪
 * @date 2020/6/319:45
 */
@RestController
@Slf4j
public class HiController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome() {
        log.info("calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        log.info("calling trace service-hi ");
        return "i'm service-hi";
    }
}

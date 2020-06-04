package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 配置中心client
 * @date 2020/6/317:05
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${test}")
    private String test;

    @RequestMapping(value = "/hi")
    public String hi(){
        return test;
    }
}

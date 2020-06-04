package com.example.sericefeign.service;

import com.example.sericefeign.feign.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Title: SchedualServiceHiHystric
 * @Version 1.0
 * @Description: Feign熔断器
 * @date 2020/6/315:15
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

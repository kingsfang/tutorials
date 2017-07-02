package com.tutorials.springboot.aop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zengpeng on 2017/4/2.
 */
@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}

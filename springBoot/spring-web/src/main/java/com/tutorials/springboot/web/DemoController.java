package com.tutorials.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by id on 3/30/2017.
 * <p>
 * <p>
 * 1. 映射请求的方式 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
 * 2. 传参的方式
 * 3. 返回数据到视图的方式
 */
@Controller
public class DemoController {

    /**
     * 映射请求的2种类型的注解
     * a. @RequestMapping
     * b. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
     * */
    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String page1() {
        return "page1";
    }

    @GetMapping("/page1a")
    public String page1a() {
        return "page1";
    }

    @DeleteMapping
    @PostMapping
    @PutMapping
    public String param1() {
        return "page2";
    }


}

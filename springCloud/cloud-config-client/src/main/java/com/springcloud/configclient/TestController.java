package com.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zengpeng on 2017/7/31.
 */
@RefreshScope
@RestController
class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    public String from() {
        return this.name;
    }
}
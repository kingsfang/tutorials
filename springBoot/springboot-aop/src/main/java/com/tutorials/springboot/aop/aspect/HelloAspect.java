package com.tutorials.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zengpeng on 2017/4/2.
 */
@Aspect
@Component
@Order(5)
public class HelloAspect {


    /**
     * 定义拦截点
     */
    @Pointcut("execution(public * com.tutorials.springboot.aop.web..*.*(..))")
    public void hello() {
    }


    @Before("hello()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        System.out.println("before.....");


    }

    @AfterReturning(returning = "ret", pointcut = "hello()")
    public void doAfterReturning(Object ret) throws Throwable {

        System.out.println("after.....");

    }

    @Around("hello()")
    public void around(JoinPoint joinPoint) {

    }

}

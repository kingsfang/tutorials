package com.tutorials.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zengpeng on 2017/4/23.
 */
@Service
public class MyScheduleService {


    // 固定间隔时间 不管上一次是否执行完成
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("fixedRate=5000");
    }

    // 上一次执行完成后间隔一定时间再执行
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeAfterSleep() {
        System.out.println("fixedDelay = 5000");
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void reportCurrentTimeCron() {
        System.out.println("cron = \"0 0 1 * * *\"");
    }
}

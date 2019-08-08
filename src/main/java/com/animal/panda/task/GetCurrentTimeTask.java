package com.animal.panda.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GetCurrentTimeTask {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //@Scheduled(cron = "5 * * * * ? ")//每分钟的第五秒执行
    public void getCurrentTime(){

        System.out.println("当前时间:"+FORMAT.format(new Date()));

    }
}

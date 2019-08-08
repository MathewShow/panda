package com.animal.panda.utils;

import com.animal.panda.pojo.Pig;
import org.springframework.beans.BeanUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) {

        /*System.out.println(0x12);
        System.out.println(00000001);*/


        mathTest();


    }

    public static void mathTest(){
        int num = (int) (Math.random() * 10);
        System.out.println(num);
    }

    public void beanUtilsTest(){
        Pig pig1 = new Pig();
        pig1.setName("旺财");
        pig1.setAge(123);
        pig1.setDesc("小猪");
        Pig pig2 = new Pig();
        BeanUtils.copyProperties(pig1,pig2);
        System.out.println(pig1.toString());
        System.out.println(pig2.toString());
    }

    public void simpleDateFormatTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));//2019-08-05 14:56:23

        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        System.out.println(sdf.format(new Date()));//2019-08-05 02:56:23 下午

        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");//
        System.out.println(sdf.format(new Date()));//2019-08-05 03:10:32 下午

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        System.out.println(sdf.format(new Date()));//2019-08-05 15:10:32:186

        sdf = new SimpleDateFormat("yyyy-MM-dd 一年中的第D天");
        System.out.println(sdf.format(new Date()));//2019-08-05 一年中的第217天

        sdf = new SimpleDateFormat("yyyy-MM-dd E");
        System.out.println(sdf.format(new Date()));//2019-08-05 星期一

        sdf = new SimpleDateFormat("yyyy-MM-dd M月中的第W个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 8月中的第2个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd M月中的第F个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 8月中的第1个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd 一年中的第w个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 一年中的第32个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd z");
        System.out.println(sdf.format(new Date()));//2019-08-05 CST
    }
}

package com.animal.panda.controller;

import com.animal.panda.pojo.Home;
import com.animal.panda.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    public Person person;
    @Autowired
    public Home home;

    @RequestMapping(value = "/getPerson")
    public Person getPersion(){
        System.out.println(person.toString());
        return person;
    }

    @RequestMapping(value = "/getHome")
    public Home getHome(){
        System.out.println(person.toString());
        System.out.println(home);
        return home;
    }
}

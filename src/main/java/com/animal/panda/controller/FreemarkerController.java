package com.animal.panda.controller;

import com.animal.panda.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    public Person person;

    @RequestMapping("/getCenter")
    public String getCenter(){
        return "freemarker/center/center";
    }

    @RequestMapping("/index")
    public String getIndex(ModelMap model){
        model.addAttribute("person",person);

        return "freemarker/index";
    }


}

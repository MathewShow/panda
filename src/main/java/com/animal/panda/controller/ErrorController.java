package com.animal.panda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class ErrorController {


    @RequestMapping("/error")
    public String error(ModelMap modelMap){

        int a = 1/0;

        return "error";
    }
}

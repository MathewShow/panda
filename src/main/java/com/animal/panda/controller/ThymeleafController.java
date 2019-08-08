package com.animal.panda.controller;

import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.PageHelperCustom;
import com.animal.panda.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("th")
public class ThymeleafController {


    @Autowired
    public AnimalService animalService;

    @RequestMapping("/center")
    public String center(){


        return "thymeleaf/center/center";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("name","李白");

        return "thymeleaf/index";
    }

    @RequestMapping("/queryAnimalById")
    public String queryAnimalById(int id,ModelMap modelMap){
        Animal animal = animalService.queryAnimalById(id);
        modelMap.addAttribute("animal",animal);

        return "thymeleaf/animal/Animal";
    }

    /**
     * 关联查询 并且分页
     * @return
     */
    @RequestMapping("/queryAnimalAndTypeByPage")
    public String queryAnimalAndTypeByPage(PageHelperCustom<Animal> page, Animal animal,ModelMap modelMap){

        page = animalService.queryAnimalAndTypeByPage(page,animal);
        modelMap.addAttribute("page",page);

        return "thymeleaf/animal/AnimalList";
    }

    @RequestMapping("/postform")
    public String postform(Animal animal){


        return "thymeleaf/animal/AnimalForm";
    }



}

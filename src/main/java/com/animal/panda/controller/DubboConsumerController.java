package com.animal.panda.controller;

import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.IMoocJSONResult;
import com.animal.panda.service.PandaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("consumer")
public class DubboConsumerController {

    @Autowired
    public PandaConsumerService pandaConsumerService;


    @RequestMapping("/getPandaById")
    public IMoocJSONResult getPandaById(Integer id) {


        Animal panda = pandaConsumerService.getPandaById(id);

        return IMoocJSONResult.ok();
    }

}

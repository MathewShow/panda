package com.animal.panda.controller;

import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.AnimalType;
import com.animal.panda.pojo.IMoocJSONResult;
import com.animal.panda.pojo.PageHelperCustom;
import com.animal.panda.service.AnimalService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    public AnimalService animalService;


    /**
     * 性能差
     * @param entity
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public IMoocJSONResult saveAnimal(Animal entity){
        long s = System.currentTimeMillis();
        List<Animal> animals = new ArrayList<>();
        String[] strArr = {"饭","懵","萌萌","蠢蠢","小","大","宝","咕咕","面条","饭桶","月","阳","槑槑"};

        for (int i = 0; i <100 ; i++) {
            int num1 = (int) (Math.random() * strArr.length);
            int num2= (int) (Math.random() * strArr.length);
            Animal animal = new Animal();
            animal.setName(strArr[num1]+strArr[num2]);
            animal.setAge(3);
            animal.setBirthday(new Date());
            animal.setType(1);
            animal.setDescription(animal.getName()+"有点调皮");
            animalService.saveAnimal(animal);

            animals.add(animal);
        }
        long e = System.currentTimeMillis();
        System.out.println("单个插入耗时:"+(e-s)+"毫秒");//测试:单个插入耗时:3170毫秒

        return IMoocJSONResult.ok(animals);
    }

    /**
     * 性能很好
     * @param entity
     * @return
     */
    @RequestMapping("/batchSave")
    @ResponseBody
    public IMoocJSONResult batchSaveAnimal(Animal entity,Integer count){
        if (count==null) count=1000;
        long s = System.currentTimeMillis();
        List<Animal> animals = new ArrayList<>();
        String[] strArr = {"饭","懵","萌萌","蠢蠢","小","大","宝","咕咕","面条","饭桶","月","阳","槑槑"};

        for (int i = 0; i <count ; i++) {
            int num1 = (int) (Math.random() * strArr.length);
            int num2= (int) (Math.random() * strArr.length);
            int num3= (int) (Math.random() * 15+1);
            int age= (int) (Math.random() * 100+1);
            Animal animal = new Animal();
            animal.setName(strArr[num1]+strArr[num2]);
            animal.setAge(age);
            animal.setBirthday(new Date());
            animal.setType(num3);
            animal.setDescription(animal.getName()+"有点调皮");

            animals.add(animal);
        }
        animalService.batchSaveAimal(animals);
        long e = System.currentTimeMillis();
        System.out.println("批量插入耗时:"+(e-s)+"毫秒");//测试:单个插入耗时:521毫秒

        return IMoocJSONResult.ok(animals);
    }

    @RequestMapping("/queryAnimalById")
    @ResponseBody
    public IMoocJSONResult queryAnimalById(int id){
        Animal animal = animalService.queryAnimalById(id);

        return IMoocJSONResult.ok(animal);
    }


    /**
     * 通过id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteAnimalById")
    @ResponseBody
    public IMoocJSONResult deleteAnimalById(int id){
        Animal animal = animalService.queryAnimalById(id);
        animalService.deleteAnimalById(108);

        return IMoocJSONResult.ok(animal);
    }

    @RequestMapping("/batchDeleteAnimal")
    @ResponseBody
    public IMoocJSONResult batchDeleteAnimal(int id){
        animalService.batchDeleteAnimal(id);

        return IMoocJSONResult.ok();
    }

    /**
     * 在mybaties中通过foreach批量删除
     * @param startId
     * @param endId
     * @return
     */
    @RequestMapping("/batchDeleteByForeach")
    @ResponseBody
    public IMoocJSONResult batchDeleteByForeach(Integer startId , Integer endId){
        List<Integer> ids = animalService.queryIds(startId,endId);
        animalService.batchDeleteByForeach(ids);

        return IMoocJSONResult.ok();
    }

    @RequestMapping("/batchDeleteAnimalCustom")
    @ResponseBody
    public IMoocJSONResult batchDeleteAnimalCustom(int id){

        animalService.batchDeleteAnimalCustom(id);

        return IMoocJSONResult.ok();
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping("/queryAnimalListPaged")
    @ResponseBody
    public IMoocJSONResult queryAnimalListPaged(Integer page){
        if (page==null){
            page=1;
        }
        int pageSize = 10;
        Animal animal = new Animal();
        //animal.setId(910);
        //animal.setName("槑");
        List<Animal> list = animalService.queryAnimalListPaged(animal,page,pageSize);

        return IMoocJSONResult.ok(list);
    }

    /**
     * 单个修改
     * @param animal
     * @return
     */
    @RequestMapping("/updateAnimalById")
    @ResponseBody
    public IMoocJSONResult updateAnimalById(Animal animal){
        animal = new Animal();
        animal.setId(10);
        animal.setName("饭萌萌");
        animalService.updateAnimalById(animal);
        animal = animalService.queryAnimalById(10);
        return IMoocJSONResult.ok(animal);
    }

    @RequestMapping("/batchUpdate")
    @ResponseBody
    public IMoocJSONResult batchUpdate(Integer startId , Integer endId){

        List<Integer> ids = animalService.queryIds(startId, endId);
        animalService.batchUpdate(ids);
        //Animal animal = new Animal();
        //List<Animal> animals = animalService.queryAnimalListPaged(animal, 1, ids.size());

        return IMoocJSONResult.ok();
    }


    /**
     * 批量插入动如类型
     * @return
     */
    @RequestMapping("/batchInsertType")
    @ResponseBody
    public IMoocJSONResult batchInsertType(){
        List<AnimalType> list = new ArrayList<AnimalType>();
        String[] arr = {"大熊猫","狗子","猫咪","羊儿","牛儿","鸡","鸭子","兔子","马儿",
                "大狗熊","老虎","狮子","猴子","老鼠","大象"};
        for (int i=0; i<arr.length; i++){
            AnimalType animalType = new AnimalType();
            animalType.setTypeText(arr[i]);
            list.add(animalType);
        }
        animalService.batchInsertType(list);
        return IMoocJSONResult.ok(list);
    }

    /**
     * 关联查询 并且分页
     * @return
     */
    @RequestMapping("/queryAnimalAndTypeByPage")
    @ResponseBody
    public IMoocJSONResult queryAnimalAndTypeByPage(PageHelperCustom<Animal> page,Animal animal){

        page = animalService.queryAnimalAndTypeByPage(page,animal);

        return IMoocJSONResult.ok(page);
    }

    /**
     * 关联查询 并且分页
     * @return
     */
    @RequestMapping("/queryAnimalByPageHelper")
    @ResponseBody
    public IMoocJSONResult queryAnimalByPageHelper(PageHelperCustom<Animal> page, Animal animal){

        page = animalService.queryAnimalByPageHelper(page,animal);


        return IMoocJSONResult.ok(page);
    }






}

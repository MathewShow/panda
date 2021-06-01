package com.animal.panda.service;


import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.AnimalType;
import com.animal.panda.pojo.PageHelperCustom;

import java.util.List;

public interface AnimalService {

    void saveAnimal(Animal animal);
    Animal queryAnimalById(int id);
    void updateAnimalById(Animal animal);
    void deleteAnimalById(int id);
    void batchDeleteAnimal(int id);
    void batchDeleteAnimalCustom(int id);
    List<Animal> queryAnimalListPaged(Animal animal, Integer page, int pageSize);
    void batchSaveAimal(List<Animal> animals);
    List<Integer> queryIds(Integer startId, Integer endId);
    void batchDeleteByForeach(List<Integer> ids);
    void batchUpdate(List<Integer> ids);
    void batchInsertType(List<AnimalType> list);
    PageHelperCustom<Animal> queryAnimalAndTypeByPage(PageHelperCustom<Animal> page,Animal animal);
    PageHelperCustom<Animal> queryAnimalByPageHelper(PageHelperCustom<Animal> page, Animal animal);
}

package com.animal.panda.mapper;

import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.AnimalType;
import com.animal.panda.pojo.PageHelperCustom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnimalMapperCustom  {

    void batchDeleteAnimalCustom(int id);

    void batchSaveAnimal(@Param("animalList") List<Animal> animals);

    List<Integer> queryIds(@Param("startId") Integer startId, @Param("endId") Integer endId);
    //ids必须@Param标记
    void batchDeleteByForeach(@Param("ids") List<Integer> ids);

    void batchUpdate(@Param("ids") List<Integer> ids);

    void batchInsertType(@Param("list") List<AnimalType> list);

    long queryAnimalAndTypeByPageCount(@Param("animal") Animal animal);

    List<Animal> queryAnimalAndTypeByPageList(@Param("animal") Animal animal,@Param("page") PageHelperCustom<Animal> page);

    List<Animal> queryAnimalAndTypeByPageHelperList(@Param("animal") Animal animal);
}
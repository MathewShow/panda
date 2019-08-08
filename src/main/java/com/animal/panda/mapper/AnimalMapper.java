package com.animal.panda.mapper;

import com.animal.panda.pojo.Animal;
import com.animal.panda.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalMapper extends MyMapper<Animal> {

    void batchDeleteAnimal(int id);
}
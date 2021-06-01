package com.animal.panda.service.impl;

import com.animal.panda.mapper.AnimalMapper;
import com.animal.panda.mapper.AnimalMapperCustom;
import com.animal.panda.pojo.Animal;
import com.animal.panda.pojo.AnimalType;
import com.animal.panda.pojo.PageHelperCustom;
import com.animal.panda.service.AnimalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {


    //@Autowired
    /**
     * 当使用@Autowired注解的时候，其实默认就是@Autowired(required=true)，表示注入的时候，该bean必须存在，
     * 否则就会注入失败。
     * @Autowired(required=false)：表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
     */
    @Autowired(required=false)
    public AnimalMapper animalMapper;

    @Autowired(required=false)
    public AnimalMapperCustom animalMapperCustom;


    /**
     * 单个插入操作
     * @param animal
     */
    @Override
    public void saveAnimal(Animal animal) {
        animalMapper.insert(animal);
    }

    /**
     * 通过id查找Animal
     * @param id
     * @return
     */
    @Override
    public Animal queryAnimalById(int id) {

        Animal animal = animalMapper.selectByPrimaryKey(id);
        return animal;
    }

    /**
     * 修改Animal
     * @param animal
     */
    @Override
    public void updateAnimalById(Animal animal) {

        //只会将实体animal中的有值属性更新
        animalMapper.updateByPrimaryKeySelective(animal);

    }

    /**
     * 通过Id删除animal
     * @param id
     */
    @Override
    public void deleteAnimalById(int id) {
        animalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDeleteAnimal(int id) {
        animalMapper.batchDeleteAnimal(id);
    }

    /**
     * 自定义批量删除
     * @param id
     */
    @Override
    public void batchDeleteAnimalCustom(int id) {
        animalMapperCustom.batchDeleteAnimalCustom(id);
    }

    /**
     * 分页查询
     * @param animal
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<Animal> queryAnimalListPaged(Animal animal, Integer page, int pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);
        Example example =new Example(Animal.class);
        Example.Criteria criteria = example.createCriteria();
        if (animal.getId()!=null){
            criteria.andEqualTo("id",animal.getId());
        }
        if (!StringUtils.isEmpty(animal.getName())){//模糊查询条件
            criteria.andLike("name","%"+animal.getName()+"%");
        }
        example.orderBy("id").desc();//降序
        List<Animal> list = animalMapper.selectByExample(example);
        return list;
    }

    @Override
    public void batchSaveAimal(List<Animal> animals) {
        animalMapperCustom.batchSaveAnimal(animals);
    }

    @Override
    public List<Integer> queryIds(Integer startId, Integer endId) {
        List<Integer> ids = animalMapperCustom.queryIds(startId,endId);
        return ids;
    }

    @Override
    public void batchDeleteByForeach(List<Integer> ids) {
        animalMapperCustom.batchDeleteByForeach(ids);
    }

    /**
     * 批量修改
     * @param ids
     */
    @Override
    public void batchUpdate(List<Integer> ids) {
        animalMapperCustom.batchUpdate(ids);
    }

    /**
     * 批量插入动物类型
     * @param list
     */
    @Override
    public void batchInsertType(List<AnimalType> list) {
        animalMapperCustom.batchInsertType(list);
    }

    @Override
    public PageHelperCustom<Animal> queryAnimalAndTypeByPage(PageHelperCustom<Animal> page , Animal animal) {

        long count = animalMapperCustom.queryAnimalAndTypeByPageCount(animal);
        page.setCount(count);
        if (count==0){
            return page;
        }
        List<Animal> list = animalMapperCustom.queryAnimalAndTypeByPageList(animal,page);
        page.setList(list);
        return page;
    }


    /**
     * 通过PageHelper实现分页
     * @param page
     * @param animal
     * @return
     */
    @Override
    public PageHelperCustom<Animal> queryAnimalByPageHelper(PageHelperCustom<Animal> page, Animal animal) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Animal> list = animalMapperCustom.queryAnimalAndTypeByPageHelperList(animal);

        long count = new PageInfo<>(list).getTotal();//获取总数
        page.setCount(count);
        page.setList(list);

        /*Page page1 = (Page)list;  这种方式也可以直接得到 count总数
        System.out.println("page1>>>>>>>>>>"+page1.getTotal());*/

        return page;
    }


}

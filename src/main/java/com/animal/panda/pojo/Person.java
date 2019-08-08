package com.animal.panda.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")//@ConfigurationProperties注解默认只能读取系统全局的配置文件，要加载非全局的配置，需要使用@PropertySource加载文件
@PropertySource("classpath:person.properties")//被application.properties覆盖了 除非将被application.properties里的键值对干掉
public class Person {
    private String name;
    private Integer age;
    private Boolean sex;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT-8")
    private Date birthday;
    private List<String> list;
    private Map<String, Object> map;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Integer age, Boolean sex, Date birthday, List<String> list,
                  Map<String, Object> map, Dog dog) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.list = list;
        this.map = map;
        this.dog = dog;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", list=" + list +
                ", map=" + map +
                ", dog=" + dog +
                '}';
    }
}

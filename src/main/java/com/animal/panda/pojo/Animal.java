package com.animal.panda.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@ToString
public class Animal {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT-8")
    private Date birthday;

    private String description;

    private Integer type;

    /**
     *  @Transient表示该属性并非一个到数据库表的字段的映射,ORM框架将忽略该属性.
     *  如果一个属性并非数据库表的字段映射,就务必将其标示为@Transient,否则,ORM框架默认其注解为@Basic
     *  并抛出列不存在的sql异常
     */
    @Transient
    private String typeText;//动物类型文字


}
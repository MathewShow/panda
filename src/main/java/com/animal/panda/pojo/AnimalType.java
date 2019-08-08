package com.animal.panda.pojo;

import javax.persistence.*;

@Table(name = "animal_type")
public class AnimalType {
    /**
     * 类型id
     */
    @Id
    private Integer id;

    /**
     * 动物类型
     */
    @Column(name = "type_text")
    private String typeText;

    /**
     * 获取类型id
     *
     * @return id - 类型id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类型id
     *
     * @param id 类型id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取动物类型
     *
     * @return type_text - 动物类型
     */
    public String getTypeText() {
        return typeText;
    }

    /**
     * 设置动物类型
     *
     * @param typeText 动物类型
     */
    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
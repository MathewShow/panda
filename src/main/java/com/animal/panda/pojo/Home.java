package com.animal.panda.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Home {
    private int nums;
    @Autowired
    private Person person;

    public Home() {
    }

    public Home(int nums, Person person) {
        this.nums = nums;
        this.person = person;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Home{" +
                "nums=" + nums +
                ", person=" + person +
                '}';
    }
}

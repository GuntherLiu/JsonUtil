package com.spring.demo01.domain.Entity;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;

public class Pet {

    @DemoEnum1("Name") private String name;
    @DemoEnum1("Age") private Integer age;

    public Pet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
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
}

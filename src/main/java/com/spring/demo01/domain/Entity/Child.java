package com.spring.demo01.domain.Entity;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;

public class Child {
    @DemoEnum1("name") private String name;
    @DemoEnum1("age") private Integer age;

    public Child() {
    }

    public Child(String name, Integer age) {
        this.name = name;
        this.age = age;
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

package com.spring.demo01.domain.Entity;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;

public class Child {
    @DemoEnum1("Name") private String name;
    @DemoEnum1("Age") private int age;

    @Override
    public String toString() {
        return String.format("name is %s, and age is %d",this.name, this.age);
    }

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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

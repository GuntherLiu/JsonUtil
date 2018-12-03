package com.spring.demo01.domain.Entity;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;


public class Person {
    @DemoEnum1("name") private String name;
    @DemoEnum1("age") private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

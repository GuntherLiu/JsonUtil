package com.spring.demo01.domain.Entity;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;

import java.util.List;


public class Person {
    @DemoEnum1("Name") private String name;
    @DemoEnum1("Age") private Integer age;
    @DemoEnum1("Child") private Child child;
    @DemoEnum1("Homes") private List<String> homes;
    @DemoEnum1("Pets") private List<Pet> pets;


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<String> getHomes() {
        return homes;
    }

    public void setHomes(List<String> homes) {
        this.homes = homes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.spring.demo01;

import com.spring.demo01.domain.Entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test2 {

    @Test
    public void test1() throws NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Field pets = clazz.getDeclaredField("pets");

        ParameterizedType type = (ParameterizedType)pets.getGenericType();

        type.getRawType();     //  获取 真实 的 参数类型class,   比如说这里就是  java.util.list

        Type[] types = type.getActualTypeArguments();   //  这个是获取 泛型的参数类型，  比如说 List<Pet>，就是获取Pet类型

        Class<?> cla = (Class<?>) types[0];     // 得到泛型实际的类型


        System.out.println();

    }


}

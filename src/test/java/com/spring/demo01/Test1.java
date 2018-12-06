package com.spring.demo01;

import org.junit.Test;

public class Test1 {

    @Test
    public  void test1(){
        Integer i = new Integer(1000);
        int i2 = 3;
        Object i2o = (Object)i2;
        boolean flag = i.getClass().equals(Integer.class);
        boolean flag2 = i2o.getClass().equals(Integer.class);
        System.out.println(flag2);

    }

}

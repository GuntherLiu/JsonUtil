package com.spring.demo01.service;


import com.spring.demo01.domain.Entity.Child;
import com.spring.demo01.domain.Entity.Person;
import com.spring.demo01.service.util.JsonUtil;
import org.json.JSONObject;

public class DemoJson01{


    public static void testJson1() throws Exception{
        String json1 = "{\"Name\":\"joey\",\"Age\":30, \"Child\":{ \"Name\":\"Tom\",\"Age\":10}, \"Homes\":[\"beijing\",\"shanghai\"]}";
        String json2 = "{\"Name\":\"Rachel\",\"Age\":28}";
        String json3 = "{\"Name\":\"joey\",\"Age\":30, \"Child\":{ \"Name\":\"Tom\",\"Age\":10}}";
        JSONObject jsonObject = new JSONObject(json1);




        Person obj = JsonUtil.jsonToBean(jsonObject, Person.class);

//        System.out.println(obj);



        return;


    }

    public  static void test() throws Exception{
        String json2 = "{\"Name\":\"Rachel\",\"Age\":28}";
        JSONObject jsonObject = new JSONObject(json2);
        Object age = jsonObject.get("Age");
        boolean flag = age.getClass().equals(Integer.class);
        Object name = jsonObject.get("Name");
        boolean flag2 = name.getClass().equals(String.class);
        System.out.println("flag: " + flag);
        System.out.println("flag2: " + flag2);

    }



    public  static void main(String[] args) throws Exception{
        testJson1();
//        test();
    }


}

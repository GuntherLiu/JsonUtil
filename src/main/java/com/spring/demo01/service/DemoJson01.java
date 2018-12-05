package com.spring.demo01.service;


import org.json.JSONObject;

public class DemoJson01{


    public static void testJson1() throws Exception{
        String json1 = "{\"name\":\"joey\",\"age\":30, \"child\":{ \"name\":\"Tom\",\"age\":10}, \"homes\":[\"beijing\",\"shanghai\"]}";

        JSONObject jsonObject = new JSONObject(json1);

        Object jsonObject2 = jsonObject.get("age");

       boolean primitive = jsonObject2.getClass().equals(String.class);

        return;


    }





    public  static void main(String[] args) throws Exception{
        testJson1();
    }


}

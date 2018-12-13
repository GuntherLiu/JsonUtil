package com.spring.demo01.service;

import com.spring.demo01.service.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DemoJson2 {

    public static void main(String[] args) throws IOException {

        String path = "file1.json";
        String json = JsonUtil.getJsonByFile(path);
        System.out.println(json);

        return;

    }

}

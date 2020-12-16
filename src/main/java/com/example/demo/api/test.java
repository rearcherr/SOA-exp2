package com.example.demo.api;
import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class test {
    public static void main(String[] args) throws  Exception {
        URL url = new URL("http://api.tianapi.com/film/index?key=2a4257c4c4e32f966f48c68547c5e872&num=10");
        try (InputStream input = url.openStream()) {
            StringBuilder jsonStr = new StringBuilder();
            byte[] buffer = new byte[512];
            int totalBytes;
            while ((totalBytes = input.read(buffer)) != -1) {
                jsonStr.append(new String(buffer, 0, totalBytes, "utf-8"));
            }
            //fastjson
            NewsData newsData = JSON.parseObject(jsonStr.toString(), NewsData.class);
            System.out.println(newsData.getCode());
            System.out.println(newsData.getMsg());
            for (News model : newsData.getNewslist()) {
                System.out.println("----------------");
                System.out.println(model.getTitle());
            }
        }
    }
}
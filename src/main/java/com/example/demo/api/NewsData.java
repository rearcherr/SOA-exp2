package com.example.demo.api;
import java.util.List;

public class NewsData {
    private int code;
    private String msg;
    private List<News> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<News> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<News> newslist) {
        this.newslist = newslist;
    }

}
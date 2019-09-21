package com.zhenhao.bean;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String pwd;
    private String secondPwd;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSecondPwd() {
        return secondPwd;
    }

    public void setSecondPwd(String secondPwd) {
        this.secondPwd = secondPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", secondPwd='" + secondPwd + '\'' +
                '}';
    }
}

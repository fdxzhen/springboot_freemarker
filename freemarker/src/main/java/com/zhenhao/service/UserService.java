package com.zhenhao.service;


import com.zhenhao.bean.User;

public interface UserService {

    public void userRegister(User user);
    public String getPwdByName(User user);
}

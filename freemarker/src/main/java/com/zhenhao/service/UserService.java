package com.zhenhao.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhenhao.bean.User;

public interface UserService {

    public void userRegister(User user);
    public String getPwdByName(User user);
    public PageInfo<User> getUserByPage(Page page, User user);
    public User getUserByName(String name);
    public  void updateUser(User user);
}

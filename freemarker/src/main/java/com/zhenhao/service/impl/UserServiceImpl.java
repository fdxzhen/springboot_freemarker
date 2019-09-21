package com.zhenhao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenhao.bean.User;
import com.zhenhao.dao.UserDao;
import com.zhenhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    @Override
    public void userRegister(User user) {
        userDao.userRegister(user);
    }

    @Override
    public String getPwdByName(User user) {
        return userDao.getPwdByName(user);
    }

    @Override
    public PageInfo<User> getUserByPage(Page page, User user) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> result = userDao.getUserList(user);
        PageInfo<User> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}

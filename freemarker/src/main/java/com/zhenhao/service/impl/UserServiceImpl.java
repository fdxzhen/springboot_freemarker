package com.zhenhao.service.impl;

import com.zhenhao.bean.User;
import com.zhenhao.dao.UserDao;
import com.zhenhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

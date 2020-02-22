package com.ven.w.shop.service.impl;

import com.ven.w.shop.commons.context.SpringContext;
import com.ven.w.shop.dao.UserDao;
import com.ven.w.shop.entity.User;
import com.ven.w.shop.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
        //return null;
    }
}

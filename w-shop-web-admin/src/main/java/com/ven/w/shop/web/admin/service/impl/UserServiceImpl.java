package com.ven.w.shop.web.admin.service.impl;

import com.ven.w.shop.domain.User;
import com.ven.w.shop.web.admin.dao.UserDao;
import com.ven.w.shop.web.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}

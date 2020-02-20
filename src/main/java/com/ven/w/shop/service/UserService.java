package com.ven.w.shop.service;

import com.ven.w.shop.entity.User;

/**
 * This is description of class
 * @author wangwenwen
 * @date 2020/2/20 16:03
 * @version v1.0.0
 */
public interface UserService {

    public User login(String email, String password);
}

package com.ven.w.shop.web.admin.dao;


import com.ven.w.shop.domain.User;

/**
 * 用户的数据操作
 * @author wangwenwen
 * @date 2020/2/20 15:33
 * @version v1.0.0
 */
public interface UserDao {

    /**
     * 根据邮箱密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User getUser(String email, String password);
}

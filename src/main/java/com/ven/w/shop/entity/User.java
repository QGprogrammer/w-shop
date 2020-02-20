package com.ven.w.shop.entity;

import java.io.Serializable;

/**
 * 用户类
 * @author wangwenwen
 * @date 2020/2/19 17:04
 * @version v1.0.0
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.ven.w.shop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * @author wangwenwen
 * @date 2020/2/24 16:09
 * @version v1.0.0
 */
@Data
public class User implements Serializable {
    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否记住账号
     */
    private boolean isRemember;
}

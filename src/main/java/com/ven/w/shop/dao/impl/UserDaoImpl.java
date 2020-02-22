package com.ven.w.shop.dao.impl;

import com.ven.w.shop.dao.UserDao;
import com.ven.w.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User getUser(String email, String password) {
        logger.debug("调用getUser(), email: {} password: {}", email, password);
        User user = null;

        if ("admin@qq.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail(email);
                user.setUsername("admin");

                logger.info("成功获取\"{}\" 的信息", user.getUsername());
            }
        } else {
            logger.warn("获取\"{}\" 的信息失败", email);
        }
        return user;
    }
}

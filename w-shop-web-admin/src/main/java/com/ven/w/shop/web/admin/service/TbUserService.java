package com.ven.w.shop.web.admin.service;


import com.ven.w.shop.commons.persistence.BaseService;
import com.ven.w.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}

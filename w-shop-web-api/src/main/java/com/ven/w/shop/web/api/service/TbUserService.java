package com.ven.w.shop.web.api.service;


import com.ven.w.shop.domain.TbUser;

public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}

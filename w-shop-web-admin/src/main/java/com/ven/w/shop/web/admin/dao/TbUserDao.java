package com.ven.w.shop.web.admin.dao;


import com.ven.w.shop.commons.persistence.BaseDao;
import com.ven.w.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}

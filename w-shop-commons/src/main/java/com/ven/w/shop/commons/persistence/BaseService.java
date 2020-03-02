package com.ven.w.shop.commons.persistence;

import com.ven.w.shop.commons.dto.BaseResult;
import com.ven.w.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 * @author wangwenwen
 * @date 2020/2/29 11:25
 * @version v1.0.0
 */
public interface BaseService<T extends BaseEntity> {

    List<T> selectAll();

    BaseResult save(T entity);

    void delete(Long id);

    T getById(Long id);

    void update(T entity);

    void deleteMulti(String[] ids);

    PageInfo<T> page(int start, int length, int draw, T entity);

    int count(T entity);
}

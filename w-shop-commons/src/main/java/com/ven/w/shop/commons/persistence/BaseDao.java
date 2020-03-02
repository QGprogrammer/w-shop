package com.ven.w.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 数据访问层基类
 * @author wangwenwen
 * @date 2020/2/29 11:17
 * @version v1.0.0
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * 查询全部数据
     * @return
     */
    List<T> selectAll();

    /**
     * 插入
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     * @param entity
     */
    void update(T entity);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params start：开始位置  length：每页数量
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 总数量
     * @param entity
     * @return
     */
    int count(T entity);
}

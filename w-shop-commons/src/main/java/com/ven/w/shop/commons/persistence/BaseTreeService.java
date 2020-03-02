package com.ven.w.shop.commons.persistence;

import com.ven.w.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用树形结构服务层
 * @author wangwenwen
 * @date 2020/2/29 12:16
 * @version v1.0.0
 */
public interface BaseTreeService<T extends BaseEntity> {

    /**
     * 查询全部数据
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     *
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 查询信息
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);

}

package com.ven.w.shop.web.admin.service;


import com.ven.w.shop.commons.persistence.BaseService;
import com.ven.w.shop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}

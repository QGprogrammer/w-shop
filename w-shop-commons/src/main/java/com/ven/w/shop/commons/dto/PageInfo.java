package com.ven.w.shop.commons.dto;

import com.ven.w.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 分页传输对象
 * @author wangwenwen
 * @date 2020/2/29 11:12
 * @version v1.0.0
 */
@Data
public class PageInfo<T extends BaseEntity> {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;


}

package com.ven.w.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 * @author wangwenwen
 * @date 2020/2/29 11:18
 * @version v1.0.0
 */
@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date Updated;
}

package com.ven.w.shop.commons.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义统一的返回结果
 * @author wangwenwen
 * @date 2020/2/29 10:59
 * @version v1.0.0
 */
@Data
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    /**
     * 状态码
     */
    private int status;

    /**
     * http消息
     */
    private String message;

    /**
     * 数据对象
     */
    private Object data;

    public BaseResult() {
        this.status = STATUS_SUCCESS;
    }

    public static BaseResult success(String message) {
        return createReasult(STATUS_SUCCESS, message, null);
    }

    public static BaseResult success(String message, Object data) {
        return createReasult(STATUS_SUCCESS, message ,data);
    }

    public static BaseResult fail() {
        return BaseResult.createReasult(STATUS_FAIL, "失败", null);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createReasult(STATUS_SUCCESS, message, null);
    }

    private static BaseResult createReasult(int stauts, String message, Object data) {
        BaseResult result = new BaseResult();
        result.setStatus(stauts);
        result.setMessage(message);
        result.setData(data);
        return result;
    }


}

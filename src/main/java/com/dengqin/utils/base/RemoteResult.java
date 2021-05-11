package com.dengqin.utils.base;

import com.alibaba.fastjson.JSON;
import com.jd.cb.hishop.price.domain.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by dq on 2020/1/15
 */
@ApiModel(value = "请求结果")
public class RemoteResult<T> implements Serializable {

    private static final long serialVersionUID = 4841381820884148523L;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "成功标识")
    private Boolean success;

    @ApiModelProperty(value = "详情数据")
    private T data;

    @ApiModelProperty(value = "失败信息")
    private String message;

    public RemoteResult() {
    }

    public RemoteResult(T data) {
        this(ErrorCodeEnum.SUCCESS.getCode(), true, data);
    }

    public RemoteResult(Integer code, Boolean success) {
        this(code, success, null);
    }

    public RemoteResult(Integer code, Boolean success, T data) {
        this(code, success, data, "");
    }

    public RemoteResult(Integer code, Boolean success, T data, String message) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static RemoteResult success() {
        return new RemoteResult(200, true);
    }

    public static <T> RemoteResult success(T obj) {
        return new RemoteResult(obj);
    }

    public static <T> RemoteResult fail(T obj) {
        if (obj instanceof ErrorCodeEnum) {
            ErrorCodeEnum codeEnum = (ErrorCodeEnum) obj;
            return fail(codeEnum.getCode(), null, codeEnum.getDesc());
        }
        return fail(ErrorCodeEnum.UNKNOWN.getCode(), obj);
    }

    public static <T> RemoteResult fail(ErrorCodeEnum codeEnum, T obj) {
        return fail(codeEnum.getCode(), obj, codeEnum.getDesc());
    }

    public static <T> RemoteResult fail(Integer code, T obj) {
        return fail(code, obj, "");
    }

    public static <T> RemoteResult fail(Integer code, T obj, String message) {
        return new RemoteResult(code, false, obj, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

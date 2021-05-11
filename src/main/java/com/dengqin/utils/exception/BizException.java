package com.dengqin.utils.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * @description: 业务异常
 * @author: jiangyanggen
 * @create: 2020-11-20 11:14
 **/
@ApiModel(value = "义务异常信息")
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 7112268987899705583L;

    @ApiModelProperty("错误码")
    private Integer code;

    @ApiModelProperty("错误信息中的占位信息")
    private Object[] data;

    public BizException(Integer code) {
        this.code = code;
    }

    public BizException(Integer code, String errorMsg) {
        super(errorMsg);
        this.code = code;
    }

    public BizException(Integer code, String errorMsg, Object[] data) {
        super(errorMsg);
        this.code = code;
        this.data = data;
    }

    public BizException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BizException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public Object[] getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public String toString() {
        return "BizException(code=" + this.getCode() + ", data=" + Arrays.deepToString(this.getData()) + ")";
    }
}

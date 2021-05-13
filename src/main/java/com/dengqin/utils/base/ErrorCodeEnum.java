package com.dengqin.utils.base;

/**
 * @description: 错误码
 * @create: 2020-12-03 18:20
 * 返回给前端的码
 *
 * <p>
 * 1、码规约: 主码（http码前缀）（三位） + 类型码（一位） + 子码区间（五位）
 * 1.1、主码: MainCode
 * 1.2、类型码: TypeCode
 * 1.3、子码
 * 依赖服务异常: 06000～06999
 * 系统内部异常: 07000～07999
 * <p>
 * 特殊码仅有主码，位数与主码相同
 **/
public enum ErrorCodeEnum {
    //
    // 普通返回码
    // 200
    SUCCESS(MainCode.SUCCESS, "成功"),
    //-1
    UNKNOWN(MainCode.UNKNOWN, "失败(未知异常)"),

    //
    // 通用异常定义（入参异常）
    COMMON_ERROR_PRICE_PARAM_ERROR(MainCode.C_ERROR, TypeCode.BIZ, 1000, "参数校验异常"),


    ;


    /**
     * 对外响应吗
     */
    private Integer code;

    /**
     * 主码
     */
    private int mainCode;

    /**
     * 类型码
     */
    private int typeCode;

    /**
     * 子码
     */
    private int subCode;

    /**
     * 异常描述
     */
    private String desc;

    /**
     * 构造枚举
     * 只含mainCode
     *
     * @param mainCode
     * @param desc
     */
    ErrorCodeEnum(int mainCode, String desc) {
        this.mainCode = mainCode;
        this.typeCode = -1;
        this.subCode = -1;
        this.desc = desc;
        this.code = this.mainCode;
    }

    /**
     * 构造枚举
     * mainCode + typeCode + subCode
     *
     * @param mainCode
     * @param typeCode
     * @param subCode
     * @param desc
     */
    ErrorCodeEnum(int mainCode, int typeCode, int subCode, String desc) {
        this.mainCode = mainCode;
        this.typeCode = typeCode;
        this.subCode = subCode;
        this.desc = desc;
        this.code = this.mainCode * 1000000 + this.typeCode * 100000 + this.subCode;
    }

    /**
     * 对外异常码
     *
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * code描述
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 解析异常类型
     *
     * @param code
     * @return
     */
    public static ErrorCodeEnum valueOf(Integer code) {
        for (ErrorCodeEnum codeEnum : values()) {
            if (codeEnum.getCode().equals(code)) {
                return codeEnum;
            }
        }
        return UNKNOWN;
    }
}

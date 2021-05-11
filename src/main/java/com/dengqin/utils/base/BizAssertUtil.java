package com.dengqin.utils.base;


import com.dengqin.utils.exception.BizException;

/**
 * Created by dq on 2020/11/29
 */
public class BizAssertUtil {

    /**
     * 断言表达式为true
     *
     * @param expression 表达式
     * @param resultCode 断言失败时抛出的返回码
     */
    public static void isTrue(boolean expression, Integer resultCode) {
        isTrue(expression, resultCode, null);
    }

    /**
     * 断言表达式为true
     *
     * @param expression 表达式
     * @param msg        断言失败时抛出的返回码
     */
    public static void isTrue(boolean expression, String msg) {
        isTrue(expression, null, msg);
    }

    /**
     * 断言表达式为true
     *
     * @param expression 表达式
     * @param resultCode 断言失败时抛出的返回码
     * @param msg        断言失败时抛出的错误信息
     */
    public static void isTrue(boolean expression, Integer resultCode, String msg) {
        if (!expression) {
            throw new BizException(resultCode, msg);
        }
    }

    /**
     * 断言对象不为null
     *
     * @param object     对象
     * @param resultCode 断言失败时抛出的返回码
     */
    public static void notNull(Object object, Integer resultCode) {
        notNull(object, resultCode, null);
    }

    /**
     * 断言对象不为null
     *
     * @param object 对象
     * @param msg    断言失败时抛出的返回码
     */
    public static void notNull(Object object, String msg) {
        notNull(object, null, msg);
    }

    /**
     * 断言对象不为null
     *
     * @param object     对象
     * @param resultCode 断言失败时抛出的返回码
     * @param msg        断言失败时抛出的错误信息
     */
    public static void notNull(Object object, Integer resultCode, String msg) {
        if (object == null) {
            throw new BizException(resultCode, msg);
        }
    }
}

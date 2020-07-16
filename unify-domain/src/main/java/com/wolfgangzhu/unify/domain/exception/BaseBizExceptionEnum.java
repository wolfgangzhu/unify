package com.wolfgangzhu.unify.domain.exception;

/**
 * @author wolfgang
 * @date 2020-07-10 18:50:57
 * @version $ Id: BaseBizExceptionEnum.java, v 0.1  wolfgang Exp $
 */
public enum BaseBizExceptionEnum implements BizExceptionEnumInterface {
    UNEXPECTED_ERROR(1, "UNEXPECTED_ERROR", "UNEXPECTED_ERROR");

    private String code;
    private String msg;
    private int    ret;

    private BaseBizExceptionEnum(int ret, String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.ret = ret;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public int getRet() {
        return this.ret;
    }
}

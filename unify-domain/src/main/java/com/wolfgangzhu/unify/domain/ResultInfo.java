package com.wolfgangzhu.unify.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wolfgangzhu.unify.domain.exception.BaseBizExceptionEnum;
import com.wolfgangzhu.unify.domain.exception.BizException;
import com.wolfgangzhu.unify.domain.exception.BizExceptionEnumInterface;

/**
 * @author wolfgang
 * @date 2020-07-13 09:34:49
 * @version $ Id: ResultInfo.java, v 0.1  wolfgang Exp $
 */
public class ResultInfo<T> {
    private static final long    serialVersionUID = 4886206811288786668L;
    private              boolean success          = false;
    private              int     ret;
    private              String  code;
    private              String  msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private              T       data;

    public static final ResultInfo SUCCESS = succeed();

    public ResultInfo() {
        this.ret = BaseBizExceptionEnum.UNEXPECTED_ERROR.getRet();
        this.code = BaseBizExceptionEnum.UNEXPECTED_ERROR.getCode();
        this.msg = BaseBizExceptionEnum.UNEXPECTED_ERROR.getMsg();
        this.data = null;
    }

    protected ResultInfo(boolean success, int ret, String code, String msg, T data) {
        this.success = success;
        this.ret = 0;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void copy(ResultInfo<T> other) {
        this.withSuccess(other.isSuccess()).withRet(other.getRet()).withCode(other.getCode()).withMsg(other.getMsg()).withData(
                other.getData());
    }

    public static <T> ResultInfo<T> succeed() {

        return succeed(null);
    }

    public static <T> ResultInfo<T> succeed(T data) {

        return succeed(data, "SUCCESS", "Successful Request.");
    }

    public static <T> ResultInfo<T> succeed(T data, String code, String msg) {
        return new ResultInfo<T>(true, 0, code, msg, data);
    }

    public ResultInfo<T> withSuccess(boolean success) {
        this.success = success;
        if (success) {
            this.ret = 0;
        }

        return this;
    }

    public ResultInfo<T> withRet(int ret) {
        this.ret = ret;
        return this;
    }

    public ResultInfo<T> withCode(String code) {
        this.code = code;
        return this;
    }

    public ResultInfo<T> withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultInfo<T> withData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResultInfo<T> fail(BizExceptionEnumInterface e) {
        return fail(e.getRet(), e.getCode(), e.getMsg());

    }

    public static <T> ResultInfo<T> fail(BizException bizException) {
        return fail(bizException.getExceptionRet(), bizException.getExceptionCode(), bizException.getMessage());
    }

    public static <T> ResultInfo<T> fail(ResultInfo<T> other) {
        return new ResultInfo<T>(false, other.getRet(), other.getCode(), other.getMsg(), other.getData());
    }

    public static <T> ResultInfo<T> fail(int ret, String code, String msg) {
        return new ResultInfo<T>(false, ret, code, msg, null);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getRet() {
        return this.ret;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "ResultInfo [success=" + this.success + ", ret=" + this.ret + ", code=" + this.code + ", msg=" + this.msg + ", data="
                + this.data + "]";
    }
}

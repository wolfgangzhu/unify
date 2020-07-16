package com.wolfgangzhu.unify.domain.exception;

import com.wolfgangzhu.unify.utils.StringUtils;

import java.io.Serializable;

/**
 * @author wolfgang
 * @date 2020-07-10 18:50:57
 * @version $ Id: BizException.java, v 0.1  wolfgang Exp $
 */
public class BizException extends RuntimeException implements Serializable {
    private static final long     serialVersionUID = -9159942779510206342L;
    private              String   exceptionCode;
    private              Integer  exceptionRet;
    private              Object[] formatParams;

    public BizException(String exceptionCode, String exceptionMsg, Integer exceptionRet) {
        super(exceptionMsg);
        this.formatParams = null;
        this.exceptionCode = exceptionCode;
        this.exceptionRet = exceptionRet;
    }

    public BizException(BizExceptionEnumInterface e) {
        this(e.getCode(), e.getMsg(), e.getRet());
    }

    public BizException(BizExceptionEnumInterface e, String exceptionMsg) {
        this(e.getCode(), exceptionMsg, e.getRet());
    }

    public String getExceptionCode() {
        return this.exceptionCode;
    }

    public Integer getExceptionRet() {
        return this.exceptionRet;
    }

    public BizException(BizExceptionEnumInterface bizExceptionCodeEnum, Object... formatParams) {
        this(bizExceptionCodeEnum);
        this.formatParams = formatParams;
    }

    public BizException(BizExceptionEnumInterface bizExceptionCodeEnum, String messagePattern, Object... formatParams) {
        this(bizExceptionCodeEnum, getFormatMsg(messagePattern, formatParams));
        this.formatParams = formatParams;
    }

    public BizException(BizExceptionEnumInterface bizExceptionCodeEnum, Throwable cause) {
        this(bizExceptionCodeEnum);
        super.initCause(cause);
    }

    private static String getFormatMsg(String messagePattern, Object... formatParams) {
        return StringUtils.formatMessage(messagePattern, formatParams);
    }
}

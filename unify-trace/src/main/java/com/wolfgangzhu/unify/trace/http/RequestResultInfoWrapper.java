package com.wolfgangzhu.unify.trace.http;

import com.wolfgangzhu.unify.domain.ResultInfo;

/**
 * 统一加上requestId用来进行查找requestId
 *
 * @author wolfgang
 * @date 2020-07-16 16:15:03
 * @version $ Id: com.wolfgangzhu.unify.trace.http.RequestResultInfoWrapper.java, v 0.1  wolfgang Exp $
 */
public class RequestResultInfoWrapper<T> extends ResultInfo<T> {

    private String requestId;

    public RequestResultInfoWrapper(ResultInfo<T> resultInfo, String requestId) {
        this.copy(resultInfo);
        // TODO
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }
}

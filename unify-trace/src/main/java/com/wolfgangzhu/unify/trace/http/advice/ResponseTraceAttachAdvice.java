package com.wolfgangzhu.unify.trace.http.advice;

import com.wolfgangzhu.unify.domain.ResultInfo;
import com.wolfgangzhu.unify.trace.http.RequestResultInfoWrapper;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wolfgang
 * @date 2020-07-16 16:40:30
 * @version $ Id: ResponseTraceAttachAdvice.java, v 0.1  wolfgang Exp $
 */
@ControllerAdvice
public class ResponseTraceAttachAdvice implements ResponseBodyAdvice<ResultInfo> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().equals(ResultInfo.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResultInfo beforeBodyWrite(ResultInfo body, MethodParameter returnType, MediaType selectedContentType,
                                      Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String requestId = getRequestId();
        return new RequestResultInfoWrapper<>(body, requestId);
    }

    private String getRequestId() {
        return MDC.get("xRequestId");
    }
}

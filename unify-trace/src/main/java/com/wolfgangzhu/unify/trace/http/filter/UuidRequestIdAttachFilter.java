/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.wolfgangzhu.unify.trace.http.filter;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 为每次请求生成一个 UUID.randomUUID() 唯一表示，并把它加入：
 * <li>1. log MDC中增加的 xRequestId 字段；</li>
 * <li>2. http header 中 x-${sysname}-request-id</li>
 */
public class UuidRequestIdAttachFilter extends OncePerRequestFilter {

    private static final String MDC_REQUEST_ID_PLACE_HOLDER = "xRequestId";

    private String headerName;

    /**
     *
     */
    public UuidRequestIdAttachFilter(String projectName) {
        this.headerName = "x-" + projectName + "-request-id";
    }

    /**
     * @see OncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 生成requestId
        String requestId = UUID.randomUUID().toString();
        response.setHeader(headerName, requestId);
        MDC.put(MDC_REQUEST_ID_PLACE_HOLDER, requestId);
        filterChain.doFilter(request, response);
    }

}

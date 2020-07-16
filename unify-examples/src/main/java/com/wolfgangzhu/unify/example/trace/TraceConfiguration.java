package com.wolfgangzhu.unify.example.trace;

import com.wolfgangzhu.unify.trace.http.advice.ResponseTraceAttachAdvice;
import com.wolfgangzhu.unify.trace.http.filter.RandomStringRequestIdAttachFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wolfgang
 * @date 2020-07-16 17:00:24
 * @version $ Id: TraceConfiguration.java, v 0.1  wolfgang Exp $
 */
@Configuration
public class TraceConfiguration {

    @Bean
    public RandomStringRequestIdAttachFilter randomStringRequestIdAttachFilter() {
        return new RandomStringRequestIdAttachFilter("product");
    }

    @Bean
    ResponseTraceAttachAdvice responseTraceAttachAdvice() {
        return new ResponseTraceAttachAdvice();
    }
}

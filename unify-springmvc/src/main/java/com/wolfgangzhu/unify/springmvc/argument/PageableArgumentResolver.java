package com.wolfgangzhu.unify.springmvc.argument;

import com.wolfgangzhu.unify.domain.Pageable;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static com.wolfgangzhu.unify.springmvc.Constants.DEFAULT_PAGE_NUM;
import static com.wolfgangzhu.unify.springmvc.Constants.DEFAULT_PAGE_SIZE;

/**
 * @author wolfgang
 * @date 2020-07-16 16:31:48
 * @version $ Id: PageableArgumentResolver.java, v 0.1  wolfgang Exp $
 */
public class PageableArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String PARAMETER_PAGE_SIZE   = "pageSize";
    private static final String PARAMETER_PAGE_NUMBER = "pageNum";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Pageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        PageConstraint anno = methodParameter.getParameterAnnotation(PageConstraint.class);
        String curPage = webRequest.getParameter(PARAMETER_PAGE_NUMBER);
        String pageSize = webRequest.getParameter(PARAMETER_PAGE_SIZE);

        Integer curPageNum = anno == null ? DEFAULT_PAGE_NUM : anno.curPageIfMissing();
        Integer pageSizeNum = anno == null ? DEFAULT_PAGE_SIZE : anno.maxPageSize();

        if (pageSize != null) {
            Integer size = Integer.valueOf(pageSize.trim());
            if (size > 0 && size < pageSizeNum) {
                pageSizeNum = size;
            }
        }
        if (curPage != null) {
            Integer size = Integer.valueOf(curPage.trim());
            if (size > 0) {
                curPageNum = size;
            }
        }
        return new Pageable(pageSizeNum, curPageNum);
    }
}

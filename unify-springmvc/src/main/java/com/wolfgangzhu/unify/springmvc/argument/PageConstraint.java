package com.wolfgangzhu.unify.springmvc.argument;

import static com.wolfgangzhu.unify.springmvc.Constants.DEFAULT_PAGE_NUM;
import static com.wolfgangzhu.unify.springmvc.Constants.DEFAULT_PAGE_SIZE;

/**
 * @author wolfgang
 * @date 2020-07-16 17:23:56
 * @version $ Id: PageConstraint.java, v 0.1  wolfgang Exp $
 */
public @interface PageConstraint {
    /**
     * 每页最大数量.
     *
     * @return 数量
     */
    int maxPageSize() default DEFAULT_PAGE_SIZE;

    /**
     * 当前页数丢失，默认的当前所在页数.
     *
     * @return 当前页
     */
    int curPageIfMissing() default DEFAULT_PAGE_NUM;
}

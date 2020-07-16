package com.wolfgangzhu.utility.mvc.argument.model;

/**
 * @author wolfgang
 * @date 2020-07-10 18:39:57
 * @version $ Id: Pageable.java, v 0.1  wolfgang Exp $
 */
public class Pageable {

    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

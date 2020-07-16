package com.wolfgangzhu.unify.domain;

/**
 * @author wolfgang
 * @date 2020-07-10 18:50:57
 * @version $ Id: Pageable.java, v 0.1  wolfgang Exp $
 */
public class Pageable {

    private Integer pageSize;
    private Integer pageNum;

    public Pageable(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}

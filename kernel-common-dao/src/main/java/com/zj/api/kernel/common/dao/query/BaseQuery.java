package com.zj.api.kernel.common.dao.query;


import java.io.Serializable;

/**
 * Created by js on 2016/12/27.
 */
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 7057402273165863260L;

    private Integer startNum;

    private Integer pageSize;

    private String order;

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}

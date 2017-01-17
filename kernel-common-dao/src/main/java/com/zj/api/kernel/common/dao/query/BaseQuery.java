package com.zj.api.kernel.common.dao.query;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by js on 2016/12/27.
 */
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 5152573610772926751L;

    private Integer startNum;

    private Integer pageSize;

    private String order;

    private Date createTimeStart;

    private Date createTimeEnd;

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

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseQuery baseQuery = (BaseQuery) o;

        if (startNum != null ? !startNum.equals(baseQuery.startNum) : baseQuery.startNum != null) return false;
        if (pageSize != null ? !pageSize.equals(baseQuery.pageSize) : baseQuery.pageSize != null) return false;
        if (order != null ? !order.equals(baseQuery.order) : baseQuery.order != null) return false;
        if (createTimeStart != null ? !createTimeStart.equals(baseQuery.createTimeStart) : baseQuery.createTimeStart != null)
            return false;
        return createTimeEnd != null ? createTimeEnd.equals(baseQuery.createTimeEnd) : baseQuery.createTimeEnd == null;

    }

    @Override
    public int hashCode() {
        int result = startNum != null ? startNum.hashCode() : 0;
        result = 31 * result + (pageSize != null ? pageSize.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (createTimeStart != null ? createTimeStart.hashCode() : 0);
        result = 31 * result + (createTimeEnd != null ? createTimeEnd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "startNum=" + startNum +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                '}';
    }
}

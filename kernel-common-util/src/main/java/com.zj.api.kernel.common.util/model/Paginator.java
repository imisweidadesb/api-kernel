package com.zj.api.kernel.common.util.model;

import java.io.Serializable;

/**
 * 分页类
 * Created by js on 2016/12/27.
 */
public class Paginator implements Serializable, Cloneable {

    private static final long serialVersionUID = 217499941428204460L;

    /**
     * 每页最小值
     */
    public static final Integer MIN_PAGE_SIZE = 5;

    /**
     * 每页最大值
     */
    public static final Integer MAX_PAGE_SIZE = 100;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer curPage;

    /**
     * 数据总数量
     */
    private Integer dataCount;

    /**
     * 总页数
     */
    private Integer pageCount;

    public Paginator() {
    }

    public Paginator(Integer pageSize, Integer curPage, Integer dataCount) {
        this.pageSize = pageSize;
        this.curPage = curPage;
        this.dataCount = dataCount;
        setPageCount(pageSize, dataCount);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (null != dataCount)
            setPageCount(pageSize, dataCount);
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
        if (null != pageSize)
            setPageCount(pageSize, dataCount);
    }

    private void setPageCount(Integer pageSize, Integer dataCount) {
        this.pageCount = dataCount % pageSize == 0 ? dataCount / pageSize : dataCount / pageSize + 1;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paginator paginator = (Paginator) o;

        if (pageSize != null ? !pageSize.equals(paginator.pageSize) : paginator.pageSize != null) return false;
        if (curPage != null ? !curPage.equals(paginator.curPage) : paginator.curPage != null) return false;
        if (dataCount != null ? !dataCount.equals(paginator.dataCount) : paginator.dataCount != null) return false;
        return pageCount != null ? pageCount.equals(paginator.pageCount) : paginator.pageCount == null;

    }

    @Override
    public int hashCode() {
        int result = pageSize != null ? pageSize.hashCode() : 0;
        result = 31 * result + (curPage != null ? curPage.hashCode() : 0);
        result = 31 * result + (dataCount != null ? dataCount.hashCode() : 0);
        result = 31 * result + (pageCount != null ? pageCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paginator{" +
                "pageSize=" + pageSize +
                ", curPage=" + curPage +
                ", dataCount=" + dataCount +
                ", pageCount=" + pageCount +
                '}';
    }
}

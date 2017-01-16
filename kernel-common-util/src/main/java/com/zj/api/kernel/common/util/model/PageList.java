package com.zj.api.kernel.common.util.model;


import java.util.ArrayList;

/**
 * Created by js on 2016/12/27.
 */
public class PageList<E> extends ArrayList<E> {

    /**
     * 保存分页信息
     */
    private Paginator paginator;

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public PageList() {
        this.paginator = new Paginator();
    }
}

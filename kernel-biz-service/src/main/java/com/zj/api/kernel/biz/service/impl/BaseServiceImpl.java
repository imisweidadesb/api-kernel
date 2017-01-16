package com.zj.api.kernel.biz.service.impl;


import com.zj.api.kernel.biz.service.BaseService;
import com.zj.api.kernel.common.dao.BaseDAO;
import com.zj.api.kernel.common.dao.query.BaseQuery;
import com.zj.api.kernel.common.util.model.PageList;
import com.zj.api.kernel.common.util.model.Paginator;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by js on 2016/12/21.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseDAO<T> getDao();

    @Transactional
    public T getByIdLock(Integer id) {
        Assert.notNull(id, "id不能为空");
        return getDao().getByIdLock(id);
    }

    @Transactional
    public void insert(T t) {
        Assert.notNull(t, "t不能为空");
        getDao().insert(t);
    }

    @Transactional
    public void delete(Integer id) {
        Assert.notNull(id, "id不能为空");
        getDao().delete(id);
    }

    @Transactional
    public void update(T t) {
        Assert.notNull(t, "t不能为空");
        getDao().update(t);
    }

    @Transactional
    public T getById(Integer id) {
        Assert.notNull(id, "id不能为空");
        return getDao().getById(id);
    }

    @Transactional
    public <Q extends BaseQuery> List<T> getByQuery(Q q) {
        Assert.notNull(q, "q不能为空");
        return getDao().getByQuery(q);
    }

    @Transactional
    public <Q extends BaseQuery> PageList<T> getByPage(Q q, Integer curPage, Integer pageSize) {
        return getDao().getByPage(q, curPage, pageSize <= 0 ? Paginator.MIN_PAGE_SIZE : pageSize);
    }
}

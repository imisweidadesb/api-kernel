package com.zj.api.kernel.common.dao;

import com.zj.api.common.util.dao.page.PageList;
import com.zj.api.common.util.dao.query.BaseQuery;

import java.util.List;

/**
 * Created by ZJ on 2017/1/17.
 */
public interface BaseDAO<T> {
    void insert(T t);

    void delete(Integer id);

    void update(T t);

    T getById(Integer id);

    T getByIdLock(Integer id);

    <Q> List<T> getByQuery(Q q);

    <Q extends BaseQuery> PageList<T> getByPage(Q query, Integer curPage, Integer pageSize);
}

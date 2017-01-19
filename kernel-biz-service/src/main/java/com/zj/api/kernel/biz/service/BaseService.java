package com.zj.api.kernel.biz.service;

import com.zj.api.common.util.dao.page.PageList;
import com.zj.api.common.util.dao.query.BaseQuery;

import java.util.List;

/**
 * Created by js on 2016/12/21.
 */
public interface BaseService<T> {

    void insert(T t);

    void delete(Integer id);

    void update(T t);

    T getById(Integer id);

    T getByIdLock(Integer id);

    <Q extends BaseQuery> List<T> getByQuery(Q q);

    <Q extends BaseQuery> PageList<T> getByPage(Q q, Integer curPage, Integer pageSize);

}

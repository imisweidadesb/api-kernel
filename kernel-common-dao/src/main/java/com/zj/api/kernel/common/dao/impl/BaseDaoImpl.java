package com.zj.api.kernel.common.dao.impl;



import com.zj.api.kernel.common.dao.BaseDAO;
import com.zj.api.kernel.common.dao.constant.SQLConstant;
import com.zj.api.kernel.common.dao.query.BaseQuery;
import com.zj.api.kernel.common.util.model.PageList;
import com.zj.api.kernel.common.util.model.Paginator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Created by js on 2016/12/21.
 */
public class BaseDAOImpl<T> extends SqlSessionDaoSupport implements BaseDAO<T> {

    protected String nameSpace;

    /**
     * 设置mybatis命名空间
     *
     * @return
     */
    private void setNameSpace() {
        Class clz = this.getClass();
        ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        Class<T> cls = (Class<T>) types[0];
        this.nameSpace = cls.getName() + ".";
    }


    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
        setNameSpace();
    }

    public void insert(T t) {
        Assert.notNull(t, "t不能为null");
        getSqlSession().insert(nameSpace + SQLConstant.INSERT, t);
    }

    public void delete(Integer id) {
        Assert.notNull(id, "id不能为null");
        getSqlSession().delete(nameSpace + SQLConstant.DELETE_BY_ID, id);
    }

    public void update(T t) {
        Assert.notNull(t, "t不能为null");
        getSqlSession().update(nameSpace + SQLConstant.UPDATE, t);
    }

    public T getById(Integer id) {
        Assert.notNull(id, "id不能为null");
        return getSqlSession().selectOne(nameSpace + SQLConstant.SELECT_BY_ID, id);
    }

    public T getByIdLock(Integer id) {
        Assert.notNull(id, "id不能为null");
        return getSqlSession().selectOne(nameSpace + SQLConstant.SELECT_BY_ID_WITH_LOCK, id);
    }

    public <Q> List<T> getByQuery(Q q) {
        Assert.notNull(q, "query不能为null");
        return getSqlSession().selectList(nameSpace + SQLConstant.SELECT_BY_QUERY, q);
    }

    public <Q extends BaseQuery> PageList<T> getByPage(Q query, Integer curPage, Integer pageSize) {
        Assert.notNull(query, "query不能为null");
        Assert.isTrue(curPage != null && pageSize != null, "当前页为空或者页大小为空");
        int count = getSqlSession().selectOne(nameSpace + SQLConstant.SELECT_COUNT_BY_PAGE, query);
        PageList<T> pageList = new PageList<T>();
        query.setStartNum((curPage - 1) * pageSize);
        query.setPageSize(pageSize);
        Paginator paginator = new Paginator(pageSize, curPage, count);
        if (count > 0) {
            pageList.addAll((Collection<? extends T>) getSqlSession().selectList(nameSpace + SQLConstant.SELECT_BY_PAGE, query));
        }
        pageList.setPaginator(paginator);
        return pageList;

    }

}

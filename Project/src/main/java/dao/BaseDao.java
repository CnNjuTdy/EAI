package dao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/7.
 */
@Repository
public class BaseDao{
    @Autowired
    HibernateTemplate template;

    public <T> void save(final T object){
        template.saveOrUpdate(object);
    }
    public <T> void delete(final T object){
        template.delete(object);
    }

    public <T> void update(final T object){
        template.update(object);
    }

    public <T> T findById(final String id,final Class<T> entityType){
        return template.get(entityType,id);
    }


    public <T> List<T> findBySQL(final String sql, final Object[] params, final Class<T> entityType) {
        return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException {
                SQLQuery q = session.createSQLQuery(sql);// 原文: SQLQuery q = getSession().createSQLQuery(sql);
                if (params != null && params.length > 0) {
                    for (int i = 0; i < params.length; i++) {//与JDBC不同的是，此处参数的索引是以0开始，而JDBC的PreparedStatement设置参数的索引是以1开始
                        q.setParameter(i, params[i]);
                    }
                }
                return q.addEntity(entityType).list();
            }
        });
    }

    public int updateBySQL(final String sql, final Object[] params) {
        return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            public Integer doInHibernate(Session session) throws HibernateException {
                SQLQuery q = session.createSQLQuery(sql);// 原文: SQLQuery q = getSession().createSQLQuery(sql);
                if (params != null && params.length > 0) {
                    for (int i = 0; i < params.length; i++) {//与JDBC不同的是，此处参数的索引是以0开始，而JDBC的PreparedStatement设置参数的索引是以1开始
                        q.setParameter(i, params[i]);
                    }
                }
                return q.executeUpdate();
            }
        });
    }

    private HibernateTemplate getHibernateTemplate() {
        return template;
    }
}

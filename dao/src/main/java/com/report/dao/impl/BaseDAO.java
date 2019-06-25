package com.report.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.report.server.dao.entity.IEntity;
import com.report.server.dao.entity.UserInfoEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @Description 基础数据库访问层
 * @Author huguangyin
 * @Date 2019/6/19-18:17
 *  
 */
public class BaseDAO {
    // Hibernate框架加载hibernate.cfg.xml文件
    private static Configuration config = new Configuration().configure();
    protected SessionFactory sessionFactory = null;
    // 相当于得到一个Connection
    private Session session = null;

    public static void main(String[] args) throws Exception {
        List<UserInfoEntity> query = new BaseDAO().query("from user_info where id = ?", new Object[]{1212L});


        System.out.println(JSONObject.toJSONString(query));
//        query.setId(1212L);
//        query.setAdress("北京");
//        new BaseDAO().update(query);

//        System.out.println(1111111);
    }

    protected <T> T query(Long id, Class<T> clazz) throws Exception {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        return session.get(clazz, id);
    }

    protected <T> T query(String hql, Object[] params) throws Exception {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        Query query = session.createQuery(hql);

        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        return (T) query.list();
    }

    protected <T> T nativeQuery(String sql, Object[] params, Class<?> entityClazz) throws Exception {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        SQLQuery query = session.createSQLQuery(sql);

        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.addEntity(entityClazz);

        return (T) query.list();
    }

    protected Integer count(String sql, Object[] params) throws Exception {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        Query query = session.createQuery(sql);

        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return (Integer) query.iterate().next();
    }

    protected <T> Long save(T t) { //启动事务1
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Long id = (Long) session.save(t);
        trans.commit();
        return id;
    }

    protected <T> Long saveOrUpdate(IEntity t) { //启动事务1
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Long id = t.getIdent();
        if (id == null) {
            id = (Long) session.save(t);
        } else {
            session.update(t);
        }
        trans.commit();
        return id;
    }

    protected <T> void update(T t) {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        session.update(t);
        trans.commit();
    }

    protected <T> void delete(T t) {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        session.delete(t);
        trans.commit();
    }

    protected void delete(String sql, Object[] params) {
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        Query query = session.createQuery(sql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        query.executeUpdate();
        trans.commit();
    }
}

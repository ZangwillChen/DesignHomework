package com.czw.Dao.impl;

import com.czw.Dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.infinispan.interceptors.locking.ClusteringDependentLogic.log;

/**
 * Created by chenzhaowen on 2017/5/22.
 */

@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    @Resource
    public SessionFactory sessionFactory;
    private Class<T> clazz = null;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl(){                   //使用反射技术得到当前T的真实类型
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>)pt.getActualTypeArguments()[0];
        System.out.println("clazz------->>"+clazz);
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(T entity){
        //log.debug("saving EtpDynamicValue instance");
       // Transaction tran = getSession().beginTransaction();
        //try {
            getSession().save(entity);

            //log.debug("save successful");
      //  } catch (RuntimeException re) {
       //     log.error("save failed", re);
      //      throw re;
      //  }
      //  tran.commit();
      //  getSession().flush();
      //  getSession().close();
    }

    @Override
    public void delete(long id) {
        Object obj = getById(id);
        if (obj != null){
            getSession().delete(obj);
        }
    }

    @Override
    public void update(T entity){
        getSession().update(entity);
    }

    @Override
    public T getById(long id){
        return (T) getSession().get(clazz,id);
    }

    @Override
    public List<T> getByIds(Long[] ids){
        return getSession().createQuery(
                "FROM User where id IN (:ids)")
                .setParameterList("ids",ids)
                .list();
    }

    @Override
    public List<T> findall(){
        return getSession().createQuery(
                "FROM "+clazz.getSimpleName())
                .list();
    }

}
package org.codeforall.bootcamp.persistence.dao.jpa;

import org.codeforall.bootcamp.persistence.dao.Dao;
import org.codeforall.bootcamp.persistence.model.Model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenerecicJpaDAo<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    //@PersistenceContext
    protected JpaSessionManager sm;

    public GenerecicJpaDAo(JpaSessionManager sm, Class<T> modelType) {
        this.sm = sm;
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = sm.getCurrentSession();

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {
        EntityManager em = sm.getCurrentSession();
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        EntityManager em = sm.getCurrentSession();
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = sm.getCurrentSession();
        em.remove(em.find(modelType, id));
    }

    public void setModelType(Class<T> modelType) {
        this.modelType = modelType;
    }
}
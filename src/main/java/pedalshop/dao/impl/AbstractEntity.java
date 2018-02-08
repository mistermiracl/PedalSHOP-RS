/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author User
 */
abstract class AbstractEntity<T> {
    private static final String PERSISTANCE_UNIT = "pedalSHOPRSPU";
    private EntityManagerFactory emf;
    protected EntityManager em;//PROTECTED TO ACCESS THEM FROM CUSTOM QUERIES
    protected CriteriaBuilder cb;
    protected Class<T> clazz;
    
    public AbstractEntity(Class<T> clazz){
        emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);
        em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
        this.clazz = clazz;
    }
    
    public boolean create(T toInsert){
        em.getTransaction().begin();
        em.persist(toInsert);
        em.getTransaction().commit();
        return true;
    }
    
    public boolean update(T toUpdate){
        em.getTransaction().begin();
        em.merge(toUpdate);
        em.getTransaction().commit();
        return true;
    }
    
    public boolean delete(Object id){
        em.getTransaction().begin();
        em.remove(find(id));
        em.getTransaction().commit();
        return true;
    }
    
    public T find(Object id){
        return em.find(clazz, id);
    }
    
    public List<T> findAll(){
        CriteriaQuery<T> q = cb.createQuery(clazz);
        Root<T> root = q.from(clazz);
        q.select(root);
        return em.createQuery(q).getResultList();
    }
    
}




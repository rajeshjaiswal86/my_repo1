package com.test.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.test.vo.AbstractEntity;

public abstract class AbstractJPAMyBaseRepository<K, E extends AbstractEntity> implements MyBaseRepository<K, E>{
	
	protected Class<E> entityClass;
	 
    @PersistenceContext
    public EntityManager em;
 
    @SuppressWarnings("unchecked")
	@PostConstruct
    public void init() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }
 
    @Override
    public E save(final E entity) {
        em.persist(entity);
        return entity;
    }
 
    @Override
    public E update(final E entity) {
        return em.merge(entity);
    }
 
    @Override
    public void delete(final E entity) {
        em.remove(em.merge(entity));
    }
 
    @Override
    public E findById(final K id) {
        return em.find(entityClass, id);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<E> findAll() {
        return em.createNamedQuery(AbstractEntity.FIND_ALL).getResultList();
    }
}

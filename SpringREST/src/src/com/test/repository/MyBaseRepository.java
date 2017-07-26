package com.test.repository;
import java.util.List;
public interface MyBaseRepository<K,E>{
    
	E save(E entity);
    
    E update(E entity);
 
    void delete(E entity);
 
    E findById(K id);
 
    List<E> findAll();
}


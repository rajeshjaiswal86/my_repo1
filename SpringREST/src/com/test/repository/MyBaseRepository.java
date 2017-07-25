package com.test.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	  T save(T entity);
}


package com.test.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.test.repository.InvestorRepository;
import com.test.vo.Investor;
@Repository
public class InvestorRepositoryImpl implements InvestorRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Investor save(Investor investor) {
		entityManager.persist(investor);
	    return investor;
	}
	@Override
	public List<Investor> findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Investor> investors = this.entityManager.createNativeQuery("select t FROM INVESTORS t", Investor.class).getResultList();
		return investors;
	}
	@Override
	public List<Investor> findByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<Investor> investors = this.entityManager.createQuery(
				"select i from Investor i where i.email = '" + email + "'")
				.getResultList();
		return investors;
	}
}
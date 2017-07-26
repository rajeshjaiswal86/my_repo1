package com.test.repository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.test.vo.Investor;
@Service
public class InvestorRepository extends AbstractJPAMyBaseRepository<Long,Investor> {
    @SuppressWarnings("unchecked")
	public List<Investor> findByName(String name) {
        return em.createNamedQuery(Investor.FIND_BY_NAME).setParameter("name", name).getResultList();
    }
	@SuppressWarnings("unchecked")
	public List<Investor> findByEmail(String email) {
        return em.createNamedQuery(Investor.FIND_BY_EMAIL).setParameter("email", email).getResultList();
    }
}
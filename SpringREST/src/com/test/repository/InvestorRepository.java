package com.test.repository;
import java.util.List;
import com.test.vo.Investor;
public interface InvestorRepository extends MyBaseRepository<Investor, Long> {
	public List<Investor> findByName(String name);
	public List<Investor> findByEmail(String email);
}
package com.test.service;

import java.util.List;

import com.test.vo.Investor;
import com.test.vo.OutputVO;
/**
 * 
 * @author Rajesh
 *
 */
public interface InvestorService {
	public OutputVO createInvestor(Investor inputVO);
	public OutputVO updateInvestor(Investor inputVO);
	public List<Investor> findByEmail(String email);
}

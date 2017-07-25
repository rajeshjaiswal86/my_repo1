package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.repository.InvestorRepository;
import com.test.service.InvestorService;
import com.test.vo.Investor;
import com.test.vo.OutputVO;

/**
 * 
 * @author Rajesh
 * 
 */
@Service
public class InvestorServiceImpl implements InvestorService {
	// @Autowired
	// private InvestorDAO invDAO;
	@Autowired
	private InvestorRepository invRepository;
	
    @Autowired
    public InvestorServiceImpl(InvestorRepository repository) {
        this.invRepository = invRepository;
    }
	
	@Override
	public OutputVO createInvestor(Investor inputVO) {
		// return invDAO.createInvestor(inputVO);
		return null;
	}

	@Override
	public OutputVO updateInvestor(Investor inputVO) {
		// return invDAO.updateInvestor(inputVO);
		return null;
	}

	@Override
	public List<Investor> findByEmail(String email) {
		List<Investor> investorList = invRepository.findByEmail(email);
		return investorList;
	}

}

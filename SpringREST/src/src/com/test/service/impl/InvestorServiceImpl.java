package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.repository.InvestorRepository;
import com.test.service.InvestorService;
import com.test.vo.Investor;
import com.test.vo.OutputVO;

@Service
public class InvestorServiceImpl implements InvestorService {
	// @Autowired
	// private InvestorDAO invDAO;
	@Autowired
	private InvestorRepository invRepository;
	
	@Override
	public OutputVO createInvestor(Investor investor) {
		OutputVO outputVO = new OutputVO();
		List<String> outputList = new ArrayList<String>();
		// return invDAO.createInvestor(inputVO);
		invRepository.save(investor);
		outputList.add("Investor details saved successfully !");
		outputVO.setResponseList(outputList);
		return outputVO;
	}

	@Override
	public OutputVO updateInvestor(Investor investor) {
		OutputVO outputVO = new OutputVO();
		List<String> outputList = new ArrayList<String>();
		// return invDAO.updateInvestor(inputVO);
		invRepository.update(investor);
		outputList.add("Investor details updated successfully !");
		outputVO.setResponseList(outputList);
		return outputVO;
	}

	@Override
	public List<Investor> findByName(String name) {
		List<Investor> investorList = invRepository.findByName(name);
		return investorList;
	}
	
	@Override
	public List<Investor> findByEmail(String email) {
		List<Investor> investorList = invRepository.findByEmail(email);
		return investorList;
	}

}

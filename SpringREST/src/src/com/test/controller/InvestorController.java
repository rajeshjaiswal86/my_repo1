package com.test.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.repository.InvestorRepository;
import com.test.service.InvestorService;
import com.test.utils.ValidationUtils;
import com.test.vo.Investor;
import com.test.vo.OutputVO;
import com.test.vo.ValidateVO;
/**
 * 
 * @author Rajesh
 *
 */
@Controller
public class InvestorController {
	@Autowired
	private InvestorService invService;
	//@Autowired
	//InvestorRepository investorRepository;
	
    @RequestMapping(value = "/createInvestor", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity<?> createInvestor(@RequestBody Investor inputVO) {
    
    OutputVO outputVO = new OutputVO();
	ValidateVO validateVO=new ValidateVO();
	validateVO = ValidationUtils.validateInput(inputVO);
    if(validateVO!=null && validateVO.isErrorFlag()){
    	outputVO.setResponseList(validateVO.getErrorList());
    }
    else{
	    outputVO = invService.createInvestor(inputVO);
    	//Investor inv=investorRepository.save(inputVO);
    	//outputVO.setId(String.valueOf(inv.getId()));
	}
	return new ResponseEntity<OutputVO>(outputVO,HttpStatus.OK);

	}
    @RequestMapping(value = "/updateInvestor", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.PUT)
	public @ResponseBody
    ResponseEntity<?> updateInvestor(@RequestBody Investor inputVO) {
    
    OutputVO outputVO = new OutputVO();
	ValidateVO validateVO=new ValidateVO();
	validateVO = ValidationUtils.validateInput(inputVO);
    if(validateVO!=null && validateVO.isErrorFlag()){
    	outputVO.setResponseList(validateVO.getErrorList());
    }
    else{
	    outputVO = invService.updateInvestor(inputVO);
	}
	return new ResponseEntity<OutputVO>(outputVO,HttpStatus.OK);

	}
    @RequestMapping(value = "/getInvestorsByName", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
	public @ResponseBody
    List<Investor> getAllInvestorsByName(@RequestParam("name") String name) {
       
    	List<Investor> list=new ArrayList<Investor>();
    	list = invService.findByName(name);
    	return list;

	}
    @RequestMapping(value = "/getInvestorsByEmail", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
	public @ResponseBody
    List<Investor> getAllInvestorsByEmail(@RequestParam("email") String email) {
    
    	List<Investor> list=new ArrayList<Investor>();
	    list = invService.findByEmail(email);
	    return list;
	}
}
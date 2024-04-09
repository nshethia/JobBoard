package com.csye6220.esdfinalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.esdfinalproject.dao.CompanyDAO;
import com.csye6220.esdfinalproject.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDAO companyDAO;
	
	@Override
	public void save(Company company) {
		
		companyDAO.save(company);
		
	}

	@Override
	public Company getByEmail(String CompanyEmail) {
		
		return companyDAO.getByEmail(CompanyEmail);
	}

}

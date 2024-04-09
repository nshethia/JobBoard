package com.csye6220.esdfinalproject.service;

import com.csye6220.esdfinalproject.model.Company;


public interface CompanyService {

	
	public void save(Company company);
	public Company getByEmail(String CompanyEmail);
}

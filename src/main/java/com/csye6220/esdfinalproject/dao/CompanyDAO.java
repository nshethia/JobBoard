package com.csye6220.esdfinalproject.dao;

import com.csye6220.esdfinalproject.model.Company;


public interface CompanyDAO {
	public void save(Company company);
	public Company getByEmail(String CompanyEmail);
}

package com.csye6220.esdfinalproject.dao;
import java.util.List;

import com.csye6220.esdfinalproject.model.Company;


public interface CompanyDAO {
	public void save(Company company);
	public Company getByEmail(String CompanyEmail);
}

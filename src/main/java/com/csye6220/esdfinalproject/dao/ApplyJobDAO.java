package com.csye6220.esdfinalproject.dao;

import java.util.List;

import com.csye6220.esdfinalproject.model.ApplyJob;


public interface ApplyJobDAO {
	 public void save(ApplyJob applyJob);
	ApplyJob getJobById(long id);
	public List<ApplyJob> findJobsByEmail(String email);
	public List<ApplyJob> findApplicantsByEmail(String email);
	
}

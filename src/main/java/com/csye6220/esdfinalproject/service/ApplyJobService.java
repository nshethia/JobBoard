package com.csye6220.esdfinalproject.service;

import java.util.List;

import com.csye6220.esdfinalproject.model.ApplyJob;


public interface ApplyJobService {
	 public void save(ApplyJob applyJob);
	 ApplyJob getJobById(long id);
	 public List<ApplyJob> findJobsByEmail(String email);
	 public List<ApplyJob> findApplicantsByEmail(String email);
		
}

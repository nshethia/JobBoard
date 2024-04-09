package com.csye6220.esdfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.esdfinalproject.dao.ApplyJobDAO;
import com.csye6220.esdfinalproject.model.ApplyJob;


@Service
public class ApplyJobServiceImpl implements ApplyJobService{
	
	
	@Autowired 
	ApplyJobDAO applyJobDAO;

	@Override
	public void save(ApplyJob applyJob) {
		applyJobDAO.save(applyJob);
		
	}

	@Override
	public ApplyJob getJobById(long id) {
		// TODO Auto-generated method stub
		return applyJobDAO.getJobById(id);
	}

	@Override
	public List<ApplyJob> findJobsByEmail(String email) {
		// TODO Auto-generated method stub
		return applyJobDAO.findJobsByEmail(email);
	}
	@Override
	public List<ApplyJob> findApplicantsByEmail(String email) {
		// TODO Auto-generated method stub
		return applyJobDAO.findApplicantsByEmail(email);
	}

}

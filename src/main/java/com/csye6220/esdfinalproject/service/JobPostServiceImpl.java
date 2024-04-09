 package com.csye6220.esdfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.esdfinalproject.dao.JobPostDAO;
import com.csye6220.esdfinalproject.model.JobPost;

@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	JobPostDAO jobPostDAO;
	
	@Override
	public void save(JobPost jobPost) {
		this.jobPostDAO.save(jobPost);
		
	}

	@Override
	public void update(JobPost jobPost) {
		this.jobPostDAO.update(jobPost);
	}

	@Override
	public void delete(JobPost jobPost) {
		this.jobPostDAO.delete(jobPost);
		
	}

	@Override
	public List<JobPost> getAllJobs() {
	   return this.jobPostDAO.getAllJobs();
		
	}

	@Override
	public JobPost getJobById(long jobId) {
		return this.jobPostDAO.getJobById(jobId);
	}

	@Override
	public List<Object[]> getFilterJobs() {
		
		return this.jobPostDAO.getFilterJobs() ;
	}

}

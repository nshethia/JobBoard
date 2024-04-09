package com.csye6220.esdfinalproject.service;

import java.util.List;

import com.csye6220.esdfinalproject.model.JobPost;


public interface JobPostService {
	public void save(JobPost jobPost);
	public void update(JobPost jobPost);
	public void delete(JobPost jobPost);
	public List<JobPost> getAllJobs();
	JobPost getJobById(long jobId);
	public List<Object[]> getFilterJobs();

}

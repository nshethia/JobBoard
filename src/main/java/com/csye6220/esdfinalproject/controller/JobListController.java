package com.csye6220.esdfinalproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csye6220.esdfinalproject.model.JobPost;
import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.JobPostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class JobListController {
	
	@Autowired
	JobPostService jobPostService;
	


	@GetMapping("/job-list")
	public String ListAllJobs(Model model, HttpSession session, HttpServletRequest request) {
		 User user = (User)request.getSession().getAttribute("user");
		 
			
	    List<JobPost> jobList = jobPostService.getAllJobs();
	    model.addAttribute("list", jobList);
	    return "jobList";
	}
}

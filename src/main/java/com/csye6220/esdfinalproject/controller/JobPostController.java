package com.csye6220.esdfinalproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.csye6220.esdfinalproject.model.ApplyJob;
import com.csye6220.esdfinalproject.model.Company;
import com.csye6220.esdfinalproject.model.JobPost;
import com.csye6220.esdfinalproject.service.ApplyJobService;
import com.csye6220.esdfinalproject.service.JobPostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class JobPostController {
	
	@Autowired
	JobPostService jobPostService;
	@Autowired
	ApplyJobService applyJobService;
	
	
	
	@GetMapping("/posting")
	public String JobPostingForm(JobPost jobPost) {
		return "JobPost";
	}
		
	@PostMapping("/posting")
	public String JobPostedSuccess(@Valid JobPost jobPost) {
		//ModelAndView modelAndview = new ModelAndView();
		
		System.out.println(jobPost);
		jobPostService.save(jobPost);
		return "view-job-post-success";
		
	}
	
	 @GetMapping("/jobApplicants")
	    public String showAppliedJobs(Model model, HttpSession session, HttpServletRequest request, String email) {
		 Company company= (Company)request.getSession().getAttribute("company");
		      email=company.getCompanyName();
		      
	           List<ApplyJob> appliedJobs = applyJobService.findApplicantsByEmail(email);
	            model.addAttribute("appliedJobs", appliedJobs);
	       
	        return "job_applicants"; 
	    }
	
	
}



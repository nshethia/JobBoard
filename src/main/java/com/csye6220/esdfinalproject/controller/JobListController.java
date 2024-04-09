package com.csye6220.esdfinalproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csye6220.esdfinalproject.model.JobPost;
import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.JobPostService;
import com.csye6220.esdfinalproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

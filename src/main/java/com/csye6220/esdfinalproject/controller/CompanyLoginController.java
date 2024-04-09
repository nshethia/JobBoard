package com.csye6220.esdfinalproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csye6220.esdfinalproject.model.Company;
import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.CompanyService;
import com.csye6220.esdfinalproject.service.JobPostService;
import com.csye6220.esdfinalproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;



@Controller
@Validated
public class CompanyLoginController {
	
	@Autowired
	CompanyService companyService;

	 @GetMapping("/commpany-login")
	    public String showLoginForm(ModelMap model) {
	        model.addAttribute("company", new Company());
	        return "companyLogin";
	    }
	    
	  
	    @PostMapping("/company-login-action")
	    public ModelAndView LoginAction(Company company, BindingResult result, HttpServletRequest request) {
	    	
	        ModelAndView modelAndView = new ModelAndView();

	        if (result.hasErrors()) {
	            modelAndView.setViewName("companylogin");
	            return modelAndView;
	        }

	       Company storedUser=companyService.getByEmail(company.getCompanyEmail());
	   
	        System.out.println(storedUser);
	        if (storedUser != null && company.getPassword().equals(storedUser.getPassword())) {
	        	request.getSession().setAttribute("company", company);
	            modelAndView.setViewName("redirect:/posting");
	            
	        } else {
	        	result.rejectValue("companyEmail", "error.company", "Invalid email or password");
	            modelAndView.setViewName("companyLogin"); 
	        }
	        return modelAndView;
	
	    }
}

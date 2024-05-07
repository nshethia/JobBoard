package com.csye6220.esdfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.JobPostService;
import com.csye6220.esdfinalproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@Validated
public class UserLoginController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    JobPostService jobPostService;
    
    @GetMapping("/login")
    public String showLoginForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
  
    @PostMapping("/login-action")
    public ModelAndView LoginAction(@Valid User user, BindingResult result, HttpServletRequest request) {
    	
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("login");
            return modelAndView;
        }

        User storedUser = userService.getUserByEmail(user.getEmail());
        
        if (storedUser != null && user.getPassword().equals(storedUser.getPassword())) {
        	
            modelAndView.setViewName("redirect:/job-list");
            request.getSession().setAttribute("user", user);
            
        } else {
        	result.rejectValue("email", "error.user", "Invalid email or password");
            modelAndView.setViewName("login"); 
        }
        return modelAndView;
    }
}



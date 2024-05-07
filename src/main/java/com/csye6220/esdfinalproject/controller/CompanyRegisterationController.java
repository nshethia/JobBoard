package com.csye6220.esdfinalproject.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csye6220.esdfinalproject.model.Company;
import com.csye6220.esdfinalproject.service.CompanyService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Controller
@Validated
public class CompanyRegisterationController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/companySignup")
	public String companySignUpPage() {
		return "companySignup";
	}

	@PostMapping("/Company-signup-action")
	public ModelAndView companySignupAction(@Valid Company company,
			@RequestParam @Email(message = "Email is not valid") String CompanyEmail,
			@RequestParam @Size(min = 7, max = 20, message = "Password length must be between 7 and 20 characters") String password) {
		ModelAndView modelAndView = new ModelAndView();

		Company companyExist = companyService.getByEmail(company.getCompanyEmail());

		if (companyExist != null) {

			modelAndView.addObject("error", "Email already exist, Please Login directly");
			modelAndView.setViewName("companySignup");
			return modelAndView;
		}

	
		else {
		companyService.save(company);
		modelAndView.addObject("success", "registration-successful, you can login now.");
		modelAndView.setViewName("companylogin");
		return modelAndView;
	}
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView constraintViolationException(ConstraintViolationException ex) {
		String errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));
		return new ModelAndView("error", "error", errors);
	}

}

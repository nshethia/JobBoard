package com.csye6220.esdfinalproject.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Controller
@Validated
public class UserRegisterationController {

	@Autowired
	UserService userService;

	@GetMapping("/signup")
	public String SignUpPage() {
		return "signup";
	}

	@PostMapping("/signup-action")
	public ModelAndView SignupAction(@Valid User user,
			@RequestParam @Email(message = "Email is not valid") String email,
			@RequestParam @Size(min = 5, max = 20, message = "Password length must be between 5 and 15 characters") String password) {

		ModelAndView modelAndView = new ModelAndView();
		User userExist = userService.getUserByEmail(email);

		System.out.println("user exit" + userExist);
		if (userExist != null) {
			System.out.println("if loop   " + userExist);
			modelAndView.addObject("error", "Email already exist, Please Login directly");
			modelAndView.setViewName("signup");
			return modelAndView;
		}

		
		userService.addUser(user);
		modelAndView.addObject("success", "registration-successful, you can login now.");
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView constraintViolationException(ConstraintViolationException ex) {
		String errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));
		return new ModelAndView("error", "error", errors);
	}

}
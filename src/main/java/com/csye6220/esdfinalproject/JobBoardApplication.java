package com.csye6220.esdfinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.csye6200.esdfinalproject.config.CustomRequestFilter;



@SpringBootApplication()
@ComponentScan(basePackages= {"com.csye6220.esdfinalproject.*"})
public class JobBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBoardApplication.class, args);
	}
	
	 @Bean
	    public FilterRegistrationBean<CustomRequestFilter> loggingFilter(){
	        FilterRegistrationBean<CustomRequestFilter> registrationBean = new FilterRegistrationBean<>();
	        registrationBean.setFilter(new CustomRequestFilter());
	        registrationBean.addUrlPatterns("/*");
	        return registrationBean;
	    }

}

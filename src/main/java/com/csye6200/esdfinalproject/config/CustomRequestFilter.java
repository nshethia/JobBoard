package com.csye6200.esdfinalproject.config;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;

public class CustomRequestFilter implements Filter {

 @Override
 @Order(1)
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
     HttpServletRequest req = (HttpServletRequest) request;
     HttpServletResponse res = (HttpServletResponse) response;

     String path = req.getRequestURI();
     if (!path.equals("/company-login-action") && !path.equals("/login") && !path.equals("/login-action")  && !path.equals("/signup") && !path.equals("/signup-action") && !path.equals("/Company-signup-action") && !path.equals("/") && !path.equals("/companySignup") && !path.equals("/commpany-login") ) {
         if ((req.getSession().getAttribute("user") == null) && ((req.getSession().getAttribute("company") == null) ) ) {
             res.sendRedirect("/");
             return;
         }
     }
     chain.doFilter(request, response);
 }
}

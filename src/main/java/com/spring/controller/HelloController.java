package com.spring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	
	private static Logger logger = LogManager.getLogger(HelloController.class.getName());
	
	private User user = new User("Admin", "123456");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminPage(Model model, HttpServletRequest request,
			HttpSession session) {
		
		  
		  String [] permissions = {"ROLE_ADMIN" ,"ROLE_DBA"};
		  
		  if(user.getUserName().equals("Admin") && user.getPassword().equals("123456")){
	        	logger.debug("Login  success : {}", user.getUserName());
	   			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	   			
	   			for (String permission : permissions) {
	   				grantedAuths.add(new SimpleGrantedAuthority(permission));
	   			}

	   			Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, grantedAuths);
	   			
	   			SecurityContext securityContext = SecurityContextHolder.getContext();
	   			securityContext.setAuthentication(authentication);
	   			session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		  }
		  
		System.out.println("HelloController.adminPage()");

		model.addAttribute("title", "Spring Security Spring MVC Hello World");
		model.addAttribute("message", "This is protected page - Admin Page!");
		model.addAttribute("user1", user.getUserName());
		model.addAttribute("perm", permissions.toString());
		
		session.setAttribute("First", "Access");
		session.setAttribute("Second", "Success");

		return "adminPage";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String dbaPage(Model model) {

		model.addAttribute("title", "Spring Security Hello World");
		model.addAttribute("message", "This is protected page - Database Page!");
		model.addAttribute("user1", user.getUserName());
		return "adminPage";

	}

}
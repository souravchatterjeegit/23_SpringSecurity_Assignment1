package com.cts;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CredentialController {
	@Autowired
	CredentialRepository mCredentialRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}

	// for 403 access denied page
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject(
					"msg",
					"Hi "
							+ user.getName()
							+ ", you are not allowed to view This page, please try viewing different pages or login with different credentials");
		} else {
			model.addObject("msg",
					"You are not allowed to view This page, please try viewing different pages or login with different credentials");
		}

		model.setViewName("accessDenied");
		return model;

	}
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser() {

		return "createUser";
	}
	@RequestMapping(value = "/submitUser", method = RequestMethod.POST)
	public ModelAndView submitUser(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("username is " + request.getParameter("username"));
		System.out.println("password is " + request.getParameter("password"));
		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		String[] roles = request.getParameterValues("roleId");
		String rolesToBeSent = "";
		
		mCredentialRepository.saveUser(userId, password, roles);
		model.addObject("message", "User with " + userId + " is successfully created, please login to view the pages");
		model.setViewName("createUser");
		return model;
	}
}

package com.mkyong.web.controller;

import java.util.Map;

import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.User;

@Controller
@EnableWebMvcSecurity
public class UserController {

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView goToNewUserRegistration(Map<String, Object> model) {

		String userid = "1234565";

		String role = "ROLE_USER";

		User userForm = new User();

		model.put("userForm", userForm);

		ModelAndView mav = new ModelAndView();

		mav.addObject("userid", userid);

		mav.addObject("role", role);

		mav.setViewName("user");

		return mav;
	}

	@RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
	public ModelAndView doCreateNewUser(@ModelAttribute("userForm") User user,
			Map<String, Object> model) {

		System.out.println("User Name : " + user.getUsername());

		System.out.println("Password : " + user.getPassword());

		System.out.println("Is Account Enabled : " + user.isEnabled());

		System.out
				.println("Is Account Expired : " + user.isAccountNonExpired());

		System.out.println("Is Account Locked : " + user.isAccountNonLocked());

		System.out.println("Is Credentials Expired : "
				+ user.isCredentialsNonExpired());

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "New User Created Success");

		mav.setViewName("listuser");

		return mav;

	}

}

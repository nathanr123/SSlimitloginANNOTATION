package com.cti.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cti.model.User;
import com.cti.model.UserDetail;
//import com.cti.model.UserDetail;
import com.cti.service.UserService;

@Controller
@EnableWebMvcSecurity
public class UserController {

	@Autowired
	UserService userService;

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

		Date d = new Date();

		user.setPassword(user.getPassword().split(",")[0]);

		System.out.println("User Name : " + user.getUsername());

		System.out.println("Password : " + user.getPassword());

		System.out.println("Is Account Enabled : " + user.isEnabled());

		System.out
				.println("Is Account Expired : " + user.isAccountNonExpired());

		System.out.println("Is Account Locked : " + user.isAccountNonLocked());

		System.out.println("Is Credentials Expired : "
				+ user.isCredentialsNonExpired());

		user.setCreatedtime(d);

		user.setModifiedtime(d);

		user.setUserrole("ROLE_ADMIN");

		userService.saveUser(user);

		System.out.println("New User Saved " + user.getUsername()
				+ " Successfully");

		UserDetail userdetailForm = new UserDetail();

		userdetailForm.setUsername(user.getUsername());

		model.put("userdetailForm", userdetailForm);

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "New User" + user.getUsername()
				+ " Created Successfully");

		mav.setViewName("userdetail");

		return mav;

	}

	@RequestMapping(value = "/updateuserdetail", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(
			@ModelAttribute("userdetailForm") UserDetail userDetail,
			Map<String, Object> model) {

		System.out.println("User Name : " + userDetail.getUsername());

		System.out.println("Name : " + userDetail.getFullname());

		System.out.println("Mail ID : " + userDetail.getMailid());

		System.out.println("Mobile Number : " + userDetail.getMobileno());

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", userDetail.getUsername()
				+ " Profile updated Successfully !!!!!");

		mav.setViewName("listuser");

		return mav;

	}

}

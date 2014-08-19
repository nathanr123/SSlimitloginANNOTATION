package com.cti.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import com.cti.service.UserDetailsService;
//import com.cti.model.UserDetail;
import com.cti.service.UserService;

@Controller
@EnableWebMvcSecurity
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserDetailsService userDetailService;

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView goToNewUserRegistration(Map<String, Object> model) {

		User userForm = new User();

		model.put("userForm", userForm);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("user");

		return mav;
	}

	@RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
	public ModelAndView doCreateNewUser(@ModelAttribute("userForm") User user,
			Map<String, Object> model) {

		Date d = new Date();

		user.setPassword(user.getPassword().split(",")[0]);

		user.setCreatedtime(d);

		user.setModifiedtime(d);

		user.setUserrole("ROLE_ADMIN");

		userService.saveUser(user);

		UserDetail userdetailForm = new UserDetail();

		userdetailForm.setUsername(user.getUsername());

		model.put("userdetailForm", userdetailForm);

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "New User " + user.getUsername()
				+ " Created Successfully");

		mav.setViewName("userdetail");

		return mav;

	}

	@RequestMapping(value = "/updateuserdetail", method = RequestMethod.POST)
	public String updateUserProfile(
			@ModelAttribute("userdetailForm") UserDetail userDetail,
			Map<String, Object> model) {

		Date d = new Date();

		userDetail.setCreatedtime(d);

		userDetail.setModifiedtime(d);

		userDetailService.saveUserDetail(userDetail);

		/*ModelAndView mav = new ModelAndView();

		mav.addObject("userlist", getAllUsersDetail());

		mav.addObject("msg", userDetail.getUsername()
				+ " Profile updated Successfully !!!!!");

		mav.setViewName("listuser");

		return mav;*/
		
		return "forward:/listusers";

	}
	
	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public ModelAndView listUsers() {

		ModelAndView mav = new ModelAndView();

		mav.addObject("userlist", getAllUsersDetail());

		/*mav.addObject("msg", userDetail.getUsername()
				+ " Profile updated Successfully !!!!!");*/

		mav.setViewName("listuser");

		return mav;

	}

	private List<UserDetail> getAllUsersDetail() {
		List<UserDetail> userDetailList = new ArrayList<UserDetail>();

		List<User> users = userService.listUsers();

		UserDetail ud = null;

		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {

			User user = iterator.next();

			ud = getUserDetail(user.getUsername());

			if (ud == null) {
				ud = new UserDetail();
				
				ud.setUsername(user.getUsername());

				ud.setCreatedtime(user.getCreatedtime());

				ud.setModifiedtime(user.getModifiedtime());
			}
			userDetailList.add(ud);
		}

		return userDetailList;
	}

	private UserDetail getUserDetail(String username) {
		return userDetailService.getUserDetailById(username);
	}

}

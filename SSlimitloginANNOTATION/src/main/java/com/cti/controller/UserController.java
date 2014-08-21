package com.cti.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
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

	// @Autowired
	// UserValidator userValidator;

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public @ResponseBody ModelAndView goToNewUserRegistration(
			Map<String, Object> model, ModelAndView mav) {

		User userForm = new User();

		model.put("userForm", userForm);

		mav.setViewName("user");

		return mav;
	}

	@RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
	public ModelAndView doCreateNewUser( @ModelAttribute("userForm")@Valid User userForm,
			BindingResult result, Map<String, Object> model,
			SessionStatus status, ModelAndView mav) {

		if (result.hasErrors()) {

			mav.setViewName("user");

			return mav;
		} else {
			Date d = new Date();

			userForm.setPassword(userForm.getPassword());

			userForm.setCreatedtime(d);

			userForm.setModifiedtime(d);

			userForm.setUserrole("ROLE_ADMIN");

			userService.saveUser(userForm);

			UserDetail userdetailForm = new UserDetail();

			userdetailForm.setUsername(userForm.getUsername());

			model.put("userdetailForm", userdetailForm);

			mav.addObject("msg", "New User " + userForm.getUsername()
					+ " Created Successfully");

			mav.setViewName("userdetail");

			return mav;
		}

	}

	@RequestMapping(value = "/loadUserdetail", method = RequestMethod.GET)
	public ModelAndView goUserProfileupdate(@RequestParam("user") String user,
			Map<String, Object> model, ModelAndView mav) {

		UserDetail userdetailForm = userDetailService.getUserDetailById(user);

		if (userdetailForm == null) {

			userdetailForm = new UserDetail();

			userdetailForm.setUsername(user);
		}

		model.put("userdetailForm", userdetailForm);


		mav.setViewName("userdetail");

		return mav;

	}

	@RequestMapping(value = "/updateuserdetail", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(
			@ModelAttribute("userdetailForm") UserDetail userdetailForm,
			BindingResult result, Map<String, Object> model,
			SessionStatus status, ModelAndView mav) {

		String view = "listuser";

		String msg = "";

		Date d = new Date();

		userdetailForm.setCreatedtime(d);

		userdetailForm.setModifiedtime(d);

		if (userDetailService.isUserProfileAlreadyAvailable(userdetailForm
				.getUsername())) {
			userDetailService.updateUserDetail(userdetailForm);

			view = "hello";

			msg = "Your Profile Updated Successfully !!";

		} else {

			userDetailService.saveUserDetail(userdetailForm);

			msg = userdetailForm.getFullname()
					+ " Profile Updated Successfully !!";

			mav.addObject("userlist", getAllUsersDetail());
		}

		mav.addObject("msg", msg);

		mav.setViewName(view);

		return mav;

	}

	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public ModelAndView listUsers(Map<String, Object> model, ModelAndView mav) {

		mav.addObject("userlist", getAllUsersDetail());

		/*
		 * mav.addObject("msg", userDetail.getUsername() +
		 * " Profile updated Successfully !!!!!");
		 */
		// getAllUsersDetail();

		mav.setViewName("listuser");

		return mav;

	}

	// @ModelAttribute("userlist")
	public List<UserDetail> getAllUsersDetail() {
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

	@ModelAttribute("priorityLevel")
	public Map<Integer, Integer> getPriority() {

		Map<Integer, Integer> userPriorty = new HashMap<Integer, Integer>();

		for (int i = 10; i > 0; i--) {
			userPriorty.put(i, i);
		}

		return userPriorty;
	}

}

/**
 * 
 */
package com.cti.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cti.model.User;
import com.cti.model.UserAndGroupList;
import com.cti.model.UserGroup;
import com.cti.model.UsersGroupList;
import com.cti.service.GroupService;
import com.cti.service.UserGroupListService;
import com.cti.service.UserService;

/**
 * @author nathanr_kamal
 *
 */
@Controller
@EnableWebMvcSecurity
public class GroupController {

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	@Autowired
	UserGroupListService userGroupListService;

	@RequestMapping(value = "/loadUsersAndGroups", method = RequestMethod.GET)
	public @ResponseBody ModelAndView loadUsersAndGroups(
			Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		// UserAndGroupList userAndGroupListForm = new UserAndGroupList();

		mav.addObject("userAndGroupListForm", new UserAndGroupList());
		/*
		 * User userForm = new User();
		 * 
		 * model.put("userForm", userForm);
		 */
		mav.setViewName("assignuseransgroup");

		return mav;
	}

	@RequestMapping(value = "/assignUserandGroup", method = RequestMethod.POST)
	public @ResponseBody ModelAndView assignUsersAndGroups(
			@ModelAttribute("userAndGroupListForm") UserAndGroupList userAndGroupListForm,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		Date now = new Date();

		List<UsersGroupList> usrGrpList = new ArrayList<UsersGroupList>();

		List<String> grpList = userAndGroupListForm.getToGroup();

		System.out.println(grpList.size());

		List<String> userList = userAndGroupListForm.getToUser();

		System.out.println(userList.size());

		if (grpList != null && userList != null) {
			for (Iterator<String> iterator = userList.iterator(); iterator
					.hasNext();) {
				String usr = iterator.next();
				for (Iterator<String> iterator2 = grpList.iterator(); iterator2
						.hasNext();) {
					String grp = iterator2.next();

					usrGrpList.add(new UsersGroupList(usr, grp, now, now));

				}

			}
		}

		userGroupListService.saveUsersandGroup(usrGrpList);

		mav.setViewName("hello");

		return mav;
	}

	@ModelAttribute("groupList")
	public Map<String, String> getGroupsList() {

		Map<String, String> groupsList = new HashMap<String, String>();

		List<UserGroup> groupList = groupService.listGroups();

		for (Iterator<UserGroup> iterator = groupList.iterator(); iterator
				.hasNext();) {

			UserGroup group = iterator.next();

			groupsList.put(group.getGroupid(), group.getGroupname());
		}

		return groupsList;
	}

	@ModelAttribute("usersList")
	public Map<String, String> getUsersList() {

		Map<String, String> usersList = new HashMap<String, String>();

		List<User> userList = userService.listUsers();

		for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			usersList.put(user.getUsername(), user.getUsername());
		}

		return usersList;
	}
}

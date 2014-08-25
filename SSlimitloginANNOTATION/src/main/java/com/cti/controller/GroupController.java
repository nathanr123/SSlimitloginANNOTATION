/**
 * 
 */
package com.cti.controller;

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

		mav.addObject("userAndGroupListForm", new UserAndGroupList());

		mav.setViewName("assignuseransgroup");

		return mav;
	}

	@RequestMapping(value = "/assignUserandGroup", method = RequestMethod.POST)
	public @ResponseBody ModelAndView assignUsersAndGroups(
			@ModelAttribute("userAndGroupListForm") UserAndGroupList userAndGroupListForm,
			BindingResult result, Map<String, Object> model) {

		ModelAndView mav = new ModelAndView();

		List<String> grpList = userAndGroupListForm.getToGroup();

		List<String> userList = userAndGroupListForm.getToUser();

		userGroupListService.saveUsersandGroup(userList, grpList);

		mav.addObject("msg", "Groups are Assigned to the user");
		
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

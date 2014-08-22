package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.UsersGroupList;

@Transactional
public interface UserGroupListService {

	public void saveUsersandGroup(List<UsersGroupList> userGroupList);
	
	public List<UsersGroupList> getUserGroupListByUserId(String username);
	
	public List<UsersGroupList> getUserGroupListByGroupId(String groupId);
}

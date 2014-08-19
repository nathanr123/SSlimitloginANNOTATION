package com.cti.service;

import java.util.List;

import com.cti.model.UsersGroupList;

public interface UserGroupListService {

	public List<UsersGroupList> getUserGroupListByUserId(String username);
	
	public List<UsersGroupList> getUserGroupListByGroupId(String groupId);
}

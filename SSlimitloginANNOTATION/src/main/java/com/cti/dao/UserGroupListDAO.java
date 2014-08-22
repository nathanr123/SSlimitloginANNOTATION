package com.cti.dao;

import java.util.List;

import com.cti.model.UsersGroupList;

public interface UserGroupListDAO {

	public void saveUsersandGroup(List<UsersGroupList> userGroupList);
	
	public List<UsersGroupList> getUserGroupListByUserId(String username);
	
	public List<UsersGroupList> getUserGroupListByGroupId(String groupId);
}

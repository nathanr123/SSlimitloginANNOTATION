package com.cti.service;

import java.util.List;

import com.cti.model.UserGroup;

public interface GroupService {

	public void addGroup(UserGroup group);

	public void updateGroup(UserGroup group);

	public void deletGroup(String groupId);

	public UserGroup getGroupById(String groupId);

	public List<UserGroup> listGroups();
}

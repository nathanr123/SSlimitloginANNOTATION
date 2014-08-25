package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.User;

@Transactional
public interface UserService {
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void updatePassword(User user);
	
	public void removeUser(String username);
	
	public User getUserById(String username);

	public List<User> listUsers();
	
	public List<User> listUsers(List<String> userList);
}

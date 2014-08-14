package com.cti.dao;

import java.util.List;

import com.cti.model.User;

public interface UserDAO {
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void removeUser(String username);
	
	public User getUserById(String username);

	public List<User> listUsers();	
}

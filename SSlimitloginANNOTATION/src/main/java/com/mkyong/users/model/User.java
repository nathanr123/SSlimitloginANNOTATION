package com.mkyong.users.model;

public class User {

	private String username;

	private String password;

	private String groupid;

	private int priority;

	private boolean isEnabled;

	private boolean isAccountNonExpired = true;

	private boolean isAccountNonLocked = true;

	private boolean isCredentialsNonExpired = true;

	private String createdTime;

	private String modifiedTime;

	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	public synchronized String getPassword() {
		return password;
	}

	public synchronized void setPassword(String password) {
		this.password = password;
	}

	public synchronized boolean isEnabled() {
		return isEnabled;
	}

	public synchronized void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public synchronized boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public synchronized void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public synchronized boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public synchronized void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public synchronized boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public synchronized void setCredentialsNonExpired(
			boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public synchronized int getPriority() {
		return priority;
	}

	public synchronized void setPriority(int priority) {
		this.priority = priority;
	}

	public synchronized String getCreatedTime() {
		return createdTime;
	}

	public synchronized void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public synchronized String getModifiedTime() {
		return modifiedTime;
	}

	public synchronized void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}

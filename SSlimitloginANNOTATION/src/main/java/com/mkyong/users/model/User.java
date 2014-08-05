package com.mkyong.users.model;

public class User {

	private String username;

	private String password;

	private boolean isEnabled;

	private boolean isAccountNonExpired = true;

	private boolean isAccountNonLocked = true;

	private boolean isCredentialsNonExpired = true;

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
}

package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "rems_users", catalog = "rems_db")
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

	@Id
	@Column(name = "username", nullable = false, unique = true, length = 16)
	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 16)
	public synchronized String getPassword() {
		return password;
	}

	public synchronized void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public synchronized boolean isEnabled() {
		return isEnabled;
	}

	public synchronized void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "accountNonExpired", nullable = false)
	public synchronized boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public synchronized void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	@Column(name = "accountNonLocked", nullable = false)
	public synchronized boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public synchronized void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	@Column(name = "credentialsNonExpired", nullable = false)
	public synchronized boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public synchronized void setCredentialsNonExpired(
			boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "rems_user_group"))
	@GeneratedValue(generator = "generator")
	@Column(name = "groupid", nullable = false)
	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "priority", nullable = false)
	public synchronized int getPriority() {
		return priority;
	}

	public synchronized void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name = "createdtime", nullable = false)
	public synchronized String getCreatedTime() {
		return createdTime;
	}

	public synchronized void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Column(name = "modifiedtime", nullable = false)
	public synchronized String getModifiedTime() {
		return modifiedTime;
	}

	public synchronized void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}

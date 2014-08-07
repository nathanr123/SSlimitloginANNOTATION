package com.cti.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rems_user", catalog = "rems_db")
public class User {

	// Variables for corresponding to DB Table

	private String username;

	private String password;

	private int priority;

	private boolean enabled;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private Date createdtime;

	private Date modifiedtime;

	// Constructors

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param username
	 * @param password
	 * @param priority
	 * @param enabled
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param createdtime
	 * @param modifiedtime
	 */
	public User(String username, String password, int priority,
			boolean enabled, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			Date createdtime, Date modifiedtime) {

		this.username = username;

		this.password = password;

		this.priority = priority;

		this.enabled = enabled;

		this.accountNonExpired = accountNonExpired;

		this.accountNonLocked = accountNonLocked;

		this.credentialsNonExpired = credentialsNonExpired;

		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
	}

	// Getter Methods

	/**
	 * @return the username
	 */
	@Id
	@Column(name = "username", nullable = false, unique = true, length = 16)
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return password;
	}

	/**
	 * @return the priority
	 */
	@Column(name = "priority", nullable = false)
	public int getPriority() {
		return priority;
	}

	/**
	 * @return the enabled
	 */
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the accountNonExpired
	 */
	@Column(name = "accountNonExpired", nullable = false)
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */
	@Column(name = "accountNonLocked", nullable = false)
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @return the credentialsNonExpired
	 */
	@Column(name = "credentialsNonExpired", nullable = false)
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @return the createdtime
	 */
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}

	/**
	 * @return the modifiedtime
	 */
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}

	// Setter Methods

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @param createdtime
	 *            the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * @param modifiedtime
	 *            the modifiedtime to set
	 */
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}

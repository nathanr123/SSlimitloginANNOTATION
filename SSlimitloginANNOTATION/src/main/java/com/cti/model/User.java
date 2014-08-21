package com.cti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "rems_user")
//@ValidPasswords.List(value = { @ValidPasswords(password = "password", confirmPassword = "confirmPassword", message = "Password and Confirm password does not match") })
public class User implements Serializable {

	// Variables for corresponding to DB Table

	/**
	 * 
	 */

	private static final long serialVersionUID = -7189115628317969160L;

	@NotNull
	@Size(min = 6, max = 16)
	private String username;

	@NotNull
	@Size(min = 6, max = 16)
	private String password;

	@NotNull
	@Size(min = 6, max = 16)
	private String confirmPassword;

	@Min(value = 1)
	private int priority = -1;

	private String userrole;

	private boolean enabled = true;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked = true;

	private boolean credentialsNonExpired = true;

	private Date createdtime;

	private Date modifiedtime;

	// Constructors

	/**
	 * 
	 */
	public User() {
	}

	public User(String username, String password, int priority,
			String userrole, boolean enabled, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			Date createdtime, Date modifiedtime) {

		this.username = username;

		this.password = password;

		this.priority = priority;

		this.userrole = userrole;

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
	@Column(name = "password", nullable = false, length = 250)
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
	 * @return the userrole
	 */
	@Column(name = "userrole", nullable = false)
	public String getUserrole() {
		return userrole;
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
	 * @param userrole
	 *            the userrole to set
	 */
	public void setUserrole(String userrole) {
		this.userrole = userrole;
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

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}

package com.cti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "rems_user_attempts", catalog = "rems_db")
public class UserAttempts {

	// Variables for corresponding to DB Table

	private String username;

	private int nofattempts;

	private Date createdtime;

	private Date modifiedtime;

	// Constructors

	/**
	 * 
	 */
	public UserAttempts() {
	}

	/**
	 * @param username
	 * @param nofattempts
	 * @param createdtime
	 * @param modifiedtime
	 */
	public UserAttempts(String username, int nofattempts, Date createdtime,
			Date modifiedtime) {

		this.username = username;

		this.nofattempts = nofattempts;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	// Getter Methods

	/**
	 * @return the username
	 */

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "rems_user"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "username", unique = true, nullable = false, length = 16)
	public String getUsername() {
		return username;
	}

	/**
	 * @return the nofattempts
	 */
	@Column(name = "nofattempts", nullable = false)
	public int getNofattempts() {
		return nofattempts;
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
	 * @param nofattempts
	 *            the nofattempts to set
	 */
	public void setNofattempts(int nofattempts) {
		this.nofattempts = nofattempts;
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
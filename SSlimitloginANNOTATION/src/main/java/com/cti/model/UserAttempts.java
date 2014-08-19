package com.cti.model;

import java.util.Date;

public class UserAttempts {

	private String username;

	private int attempts;

	private Date lastModified;
	
	private String formattedDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the formattedDate
	 */
	public String getFormattedDate() {
		return formattedDate;
	}

	/**
	 * @param formattedDate the formattedDate to set
	 */
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	
}
package com.mkyong.users.model;

public class UserDetail {

	private String username;

	private String fullname;

	private String mailid;

	private String mobileno;

	private String createdTime;

	private String modifiedTime;

	
	
	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	public synchronized String getFullname() {
		return fullname;
	}

	public synchronized void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public synchronized String getMailid() {
		return mailid;
	}

	public synchronized void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public synchronized String getMobileno() {
		return mobileno;
	}

	public synchronized void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

package com.mkyong.users.model;

public class UserDetail {

	private String username;

	private String name;

	private String mailid;

	private String mobileno;

	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
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
}

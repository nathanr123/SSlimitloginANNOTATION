package com.mkyong.users.model;

public class UserAttempts {

	private String username;
	
	private int nofattempts;
	
	private String createdtime;
	
	private String modifiedtime;

	
	
	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	public synchronized int getNofattempts() {
		return nofattempts;
	}

	public synchronized void setNofattempts(int nofattempts) {
		this.nofattempts = nofattempts;
	}

	public synchronized String getCreatedtime() {
		return createdtime;
	}

	public synchronized void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public synchronized String getModifiedtime() {
		return modifiedtime;
	}

	public synchronized void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}
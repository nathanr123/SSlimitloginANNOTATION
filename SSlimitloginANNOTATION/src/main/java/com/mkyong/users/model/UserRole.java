package com.mkyong.users.model;

public class UserRole {

	private String roleid;
	
	private String roletype;
	
	private String createdtime;
	
	private String modifiedtime;
	
	
	public synchronized String getRoleid() {
		return roleid;
	}
	public synchronized void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public synchronized String getRoletype() {
		return roletype;
	}
	public synchronized void setRoletype(String roletype) {
		this.roletype = roletype;
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

package com.mkyong.users.model;

public class UserGroup {

	private String groupid;

	private String groupname;

	private String roleid;

	private String priority;

	private String createdtime;

	private String modifiedtime;

	
	
	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public synchronized String getGroupname() {
		return groupname;
	}

	public synchronized void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public synchronized String getRoleid() {
		return roleid;
	}

	public synchronized void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public synchronized String getPriority() {
		return priority;
	}

	public synchronized void setPriority(String priority) {
		this.priority = priority;
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

package com.mkyong.users.model;

public class UserGroupPermission {

	private String groupid;

	private String component;

	private int canread;

	private int cancreate;

	private int canmodify;

	private int candelete;

	private String createdtime;

	private String modifiedtime;

	
	
	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public synchronized String getComponent() {
		return component;
	}

	public synchronized void setComponent(String component) {
		this.component = component;
	}

	public synchronized int getCanread() {
		return canread;
	}

	public synchronized void setCanread(int canread) {
		this.canread = canread;
	}

	public synchronized int getCancreate() {
		return cancreate;
	}

	public synchronized void setCancreate(int cancreate) {
		this.cancreate = cancreate;
	}

	public synchronized int getCanmodify() {
		return canmodify;
	}

	public synchronized void setCanmodify(int canmodify) {
		this.canmodify = canmodify;
	}

	public synchronized int getCandelete() {
		return candelete;
	}

	public synchronized void setCandelete(int candelete) {
		this.candelete = candelete;
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

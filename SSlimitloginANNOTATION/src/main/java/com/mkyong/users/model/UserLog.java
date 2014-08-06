package com.mkyong.users.model;

public class UserLog {

	private int logid;

	private String owner;

	private String ipaddress;

	private String loggroup;

	private String logdescription;

	private String createdtime;

	
	
	public synchronized int getLogid() {
		return logid;
	}

	public synchronized void setLogid(int logid) {
		this.logid = logid;
	}

	public synchronized String getOwner() {
		return owner;
	}

	public synchronized void setOwner(String owner) {
		this.owner = owner;
	}

	public synchronized String getIpaddress() {
		return ipaddress;
	}

	public synchronized void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public synchronized String getLoggroup() {
		return loggroup;
	}

	public synchronized void setLoggroup(String loggroup) {
		this.loggroup = loggroup;
	}

	public synchronized String getLogdescription() {
		return logdescription;
	}

	public synchronized void setLogdescription(String logdescription) {
		this.logdescription = logdescription;
	}

	public synchronized String getCreatedtime() {
		return createdtime;
	}

	public synchronized void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

}

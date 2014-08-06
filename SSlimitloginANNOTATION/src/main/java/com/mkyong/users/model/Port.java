package com.mkyong.users.model;

public class Port {

	private String portid;

	private String switchid;

	private String portname;

	private int portnumber;

	private String portstatus;

	private String porttype;

	private String createdtime;

	private String modifiedtime;

	public synchronized String getPortid() {
		return portid;
	}

	public synchronized void setPortid(String portid) {
		this.portid = portid;
	}

	public synchronized String getSwitchid() {
		return switchid;
	}

	public synchronized void setSwitchid(String switchid) {
		this.switchid = switchid;
	}

	public synchronized String getPortname() {
		return portname;
	}

	public synchronized void setPortname(String portname) {
		this.portname = portname;
	}

	public synchronized int getPortnumber() {
		return portnumber;
	}

	public synchronized void setPortnumber(int portnumber) {
		this.portnumber = portnumber;
	}

	public synchronized String getPortstatus() {
		return portstatus;
	}

	public synchronized void setPortstatus(String portstatus) {
		this.portstatus = portstatus;
	}

	public synchronized String getPorttype() {
		return porttype;
	}

	public synchronized void setPorttype(String porttype) {
		this.porttype = porttype;
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

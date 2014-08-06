package com.mkyong.users.model;

public class Switch {

	private String switchid;

	private String switchname;

	private String switchip;

	private int switchport;

	private String modelname;

	private String modelnumber;

	private String serialnumber;

	private int totalnoofports;

	private int noofingress;

	private int noofegress;

	private String createdtime;

	private String modifiedtime;

	
	
	public synchronized String getSwitchid() {
		return switchid;
	}

	public synchronized void setSwitchid(String switchid) {
		this.switchid = switchid;
	}

	public synchronized String getSwitchname() {
		return switchname;
	}

	public synchronized void setSwitchname(String switchname) {
		this.switchname = switchname;
	}

	public synchronized String getSwitchip() {
		return switchip;
	}

	public synchronized void setSwitchip(String switchip) {
		this.switchip = switchip;
	}

	public synchronized int getSwitchport() {
		return switchport;
	}

	public synchronized void setSwitchport(int switchport) {
		this.switchport = switchport;
	}

	public synchronized String getModelname() {
		return modelname;
	}

	public synchronized void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public synchronized String getModelnumber() {
		return modelnumber;
	}

	public synchronized void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}

	public synchronized String getSerialnumber() {
		return serialnumber;
	}

	public synchronized void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public synchronized int getTotalnoofports() {
		return totalnoofports;
	}

	public synchronized void setTotalnoofports(int totalnoofports) {
		this.totalnoofports = totalnoofports;
	}

	public synchronized int getNoofingress() {
		return noofingress;
	}

	public synchronized void setNoofingress(int noofingress) {
		this.noofingress = noofingress;
	}

	public synchronized int getNoofegress() {
		return noofegress;
	}

	public synchronized void setNoofegress(int noofegress) {
		this.noofegress = noofegress;
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

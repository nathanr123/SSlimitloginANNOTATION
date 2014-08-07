package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "rems_user_group_permission", catalog = "rems_db")
public class UserGroupPermission {

	private String groupid;

	private String component;

	private int canread;

	private int cancreate;

	private int canmodify;

	private int candelete;

	private String createdtime;

	private String modifiedtime;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "rems_user_group"))
	@GeneratedValue(generator = "generator")
	@Column(name = "", nullable = false, length = 10)
	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "", nullable = false, length = 10)
	public synchronized String getComponent() {
		return component;
	}

	public synchronized void setComponent(String component) {
		this.component = component;
	}

	@Column(name = "canread", nullable = false)
	public synchronized int getCanread() {
		return canread;
	}

	public synchronized void setCanread(int canread) {
		this.canread = canread;
	}

	@Column(name = "cancreate", nullable = false)
	public synchronized int getCancreate() {
		return cancreate;
	}

	public synchronized void setCancreate(int cancreate) {
		this.cancreate = cancreate;
	}

	@Column(name = "canmodify", nullable = false)
	public synchronized int getCanmodify() {
		return canmodify;
	}

	public synchronized void setCanmodify(int canmodify) {
		this.canmodify = canmodify;
	}

	@Column(name = "candelete", nullable = false)
	public synchronized int getCandelete() {
		return candelete;
	}

	public synchronized void setCandelete(int candelete) {
		this.candelete = candelete;
	}

	@Column(name = "createdtime", nullable = false)
	public synchronized String getCreatedtime() {
		return createdtime;
	}

	public synchronized void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	@Column(name = "modifiedtime", nullable = false)
	public synchronized String getModifiedtime() {
		return modifiedtime;
	}

	public synchronized void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}

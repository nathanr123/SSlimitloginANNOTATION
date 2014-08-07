package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rems_user_role", catalog = "rems_db")
public class UserRole {

	private String roleid;

	private String roletype;

	private String createdtime;

	private String modifiedtime;

	@Id
	@Column(name = "roleid", nullable = false, unique = true, length = 35)
	public synchronized String getRoleid() {
		return roleid;
	}

	public synchronized void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "roletype", nullable = false, length = 35)
	public synchronized String getRoletype() {
		return roletype;
	}

	public synchronized void setRoletype(String roletype) {
		this.roletype = roletype;
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

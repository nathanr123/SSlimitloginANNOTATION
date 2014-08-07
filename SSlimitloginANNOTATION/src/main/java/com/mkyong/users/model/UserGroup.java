package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="rems_user_group",catalog="rems_db")
public class UserGroup {

	private String groupid;

	private String groupname;

	private String roleid;

	private String priority;

	private String createdtime;

	private String modifiedtime;

	
	@Id
	@Column(name = "groupid", nullable = false, unique = true, length = 10)
	public synchronized String getGroupid() {
		return groupid;
	}

	public synchronized void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "groupname", nullable = false, length = 35)
	public synchronized String getGroupname() {
		return groupname;
	}

	public synchronized void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "rems_user_role"))
	@GeneratedValue(generator = "generator")
	@Column(name = "roleid", nullable = false)
	public synchronized String getRoleid() {
		return roleid;
	}

	public synchronized void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "priority", nullable = false)
	public synchronized String getPriority() {
		return priority;
	}

	public synchronized void setPriority(String priority) {
		this.priority = priority;
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

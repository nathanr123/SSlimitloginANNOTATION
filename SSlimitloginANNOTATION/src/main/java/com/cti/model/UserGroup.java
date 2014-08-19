package com.cti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rems_group", catalog = "rems_db")
public class UserGroup {

	// Variables for corresponding to DB Table

	private String groupid;

	private String groupname;

	private String priority;

	private Date createdtime;

	private Date modifiedtime;

	/**
	 * @param groupid
	 * @param groupname
	 * @param priority
	 * @param createdtime
	 * @param modifiedtime
	 */
	public UserGroup(String groupid, String groupname, String priority,
			Date createdtime, Date modifiedtime) {

		this.groupid = groupid;

		this.groupname = groupname;

		this.priority = priority;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	/**
	 * @return the groupid
	 */
	@Id
	@Column(name = "groupid", nullable = false, unique = true, length = 10)
	public String getGroupid() {
		return groupid;
	}

	/**
	 * @return the groupname
	 */
	@Column(name = "groupname", nullable = false, length = 35)
	public String getGroupname() {
		return groupname;
	}

	/**
	 * @return the priority
	 */
	@Column(name = "priority", nullable = false)
	public String getPriority() {
		return priority;
	}

	/**
	 * @return the createdtime
	 */
	@Column(name = "createdtime", nullable = false)
	public Date getCreatedtime() {
		return createdtime;
	}

	/**
	 * @return the modifiedtime
	 */
	@Column(name = "modifiedtime", nullable = false)
	public Date getModifiedtime() {
		return modifiedtime;
	}

	/**
	 * @param groupid
	 *            the groupid to set
	 */
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	/**
	 * @param groupname
	 *            the groupname to set
	 */
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @param createdtime
	 *            the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * @param modifiedtime
	 *            the modifiedtime to set
	 */
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}

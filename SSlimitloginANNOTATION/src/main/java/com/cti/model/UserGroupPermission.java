package com.cti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "rems_group_permission")
public class UserGroupPermission {

	// Variables for corresponding to DB Table

	private String groupid;

	private String component;

	private int canread;

	private int cancreate;

	private int canmodify;

	private int candelete;

	private Date createdtime;

	private Date modifiedtime;

	// Constructors

	/**
	 * @param groupid
	 * @param component
	 * @param canread
	 * @param cancreate
	 * @param canmodify
	 * @param candelete
	 * @param createdtime
	 * @param modifiedtime
	 */
	public UserGroupPermission(String groupid, String component, int canread,
			int cancreate, int canmodify, int candelete, Date createdtime,
			Date modifiedtime) {

		this.groupid = groupid;

		this.component = component;

		this.canread = canread;

		this.cancreate = cancreate;

		this.canmodify = canmodify;

		this.candelete = candelete;

		this.createdtime = createdtime;

		this.modifiedtime = modifiedtime;
	}

	public UserGroupPermission(String groupid, String component,
			int[] permissions, Date time) {

		this.groupid = groupid;

		this.component = component;

		this.cancreate = permissions[0];

		this.canmodify = permissions[1];

		this.candelete = permissions[2];

		this.canread = permissions[3];

		this.createdtime = time;

		this.modifiedtime = time;
	}

	// Getter Methods

	/**
	 * @return the groupid
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "rems_group"))
	@GeneratedValue(generator = "generator")
	@Column(name = "groupid", unique = true, nullable = false, length = 10)
	public String getGroupid() {
		return groupid;
	}

	/**
	 * @return the component
	 */
	@Column(name = "component", nullable = false, length = 35)
	public String getComponent() {
		return component;
	}

	/**
	 * @return the canread
	 */
	@Column(name = "canread", nullable = false)
	public int getCanread() {
		return canread;
	}

	/**
	 * @return the cancreate
	 */
	@Column(name = "cancreate", nullable = false)
	public int getCancreate() {
		return cancreate;
	}

	/**
	 * @return the canmodify
	 */
	@Column(name = "canmodify", nullable = false)
	public int getCanmodify() {
		return canmodify;
	}

	/**
	 * @return the candelete
	 */
	@Column(name = "candelete", nullable = false)
	public int getCandelete() {
		return candelete;
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

	// Setter Methods

	/**
	 * @param groupid
	 *            the groupid to set
	 */
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * @param canread
	 *            the canread to set
	 */
	public void setCanread(int canread) {
		this.canread = canread;
	}

	/**
	 * @param cancreate
	 *            the cancreate to set
	 */
	public void setCancreate(int cancreate) {
		this.cancreate = cancreate;
	}

	/**
	 * @param canmodify
	 *            the canmodify to set
	 */
	public void setCanmodify(int canmodify) {
		this.canmodify = canmodify;
	}

	/**
	 * @param candelete
	 *            the candelete to set
	 */
	public void setCandelete(int candelete) {
		this.candelete = candelete;
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

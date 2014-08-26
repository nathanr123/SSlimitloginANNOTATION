/**
 * 
 */
package com.cti.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cti.model.UserGroupPermission;

/**
 * @author dharshini
 *
 */
@Repository
public class GroupPermissionDAOEx implements GroupPermissionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupPermissionDAO#setGroupPerssions(com.cti.model.
	 * UserGroupPermission)
	 */
	@Override
	public void setGroupPerssions(UserGroupPermission userGroupPermission) {
		getCurrentSession().saveOrUpdate(userGroupPermission);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cti.dao.GroupPermissionDAO#getGroupPerssionsByGroupId(java.lang.String
	 * )
	 */
	@Override
	public List<UserGroupPermission> getGroupPerssionsByGroupId(String groupId) {

		List<UserGroupPermission> grpList = new ArrayList<UserGroupPermission>();

		Query query = getCurrentSession().createQuery(
				"from UserGroupPermission u where u.groupid = :groupid");

		query.setParameter("groupid", groupId);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList;

		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cti.dao.GroupPermissionDAO#getGroupPerssionsByComponent(java.lang
	 * .String)
	 */
	@Override
	public List<UserGroupPermission> getGroupPerssionsByComponent(
			String componentName) {
		List<UserGroupPermission> grpList = new ArrayList<UserGroupPermission>();

		Query query = getCurrentSession().createQuery(
				"from UserGroupPermission u where u.component = :component");

		query.setParameter("component", componentName);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList;

		else
			return null;
	}

	@Override
	public void setGroupPerssions(
			List<UserGroupPermission> userGroupPermissionList) {

		for (Iterator<UserGroupPermission> iterator = userGroupPermissionList
				.iterator(); iterator.hasNext();) {
			UserGroupPermission userGroupPermission = iterator.next();

			setGroupPerssions(userGroupPermission);
		}

	}

	@Override
	public List<UserGroupPermission> getGroupPerssions(String groupId,
			String componentName) {
		List<UserGroupPermission> grpList = new ArrayList<UserGroupPermission>();

		Query query = getCurrentSession()
				.createQuery(
						"from UserGroupPermission u where u.groupid = :groupid and u.component=:componentname");

		query.setParameter("groupid", groupId);

		query.setParameter("componentname", componentName);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList;

		else
			return null;
	}

}

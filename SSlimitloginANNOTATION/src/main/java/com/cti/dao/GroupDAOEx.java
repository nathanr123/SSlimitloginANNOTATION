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

import com.cti.model.UserGroup;

/**
 * @author dharshini
 *
 */
@Repository
public class GroupDAOEx implements GroupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupDAO#addGroup(com.cti.model.UserGroup)
	 */
	@Override
	public void addGroup(UserGroup group) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupDAO#updateGroup(com.cti.model.UserGroup)
	 */
	@Override
	public void updateGroup(UserGroup group) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupDAO#deletGroup(java.lang.String)
	 */
	@Override
	public void deletGroup(String groupId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupDAO#getGroupById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserGroup getGroupById(String groupId) {
		List<UserGroup> grpList = new ArrayList<UserGroup>();

		Query query = getCurrentSession().createQuery(
				"from UserGroup u where u.groupid = :groupid");

		query.setParameter("groupid", groupId);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList.get(0);

		else
			return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.GroupDAO#listGroups()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> listGroups() {

		return getCurrentSession().createQuery("from UserGroup").list();

	}

	@Override
	public List<UserGroup> listGroups(List<String> grpList) {

		List<UserGroup> userGroupList = new ArrayList<UserGroup>();

		for (Iterator<String> iterator = grpList.iterator(); iterator.hasNext();) {
			String group = (String) iterator.next();

			userGroupList.add(getGroupById(group));

		}
		return userGroupList;
	}

}

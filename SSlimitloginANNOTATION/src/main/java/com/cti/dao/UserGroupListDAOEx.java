/**
 * 
 */
package com.cti.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cti.model.UsersGroupList;

/**
 * @author dharshini
 *
 */
@Repository
public class UserGroupListDAOEx implements UserGroupListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<UsersGroupList> getUserGroupListByUserId(String username) {
		List<UsersGroupList> grpList = new ArrayList<UsersGroupList>();

		Query query = openSession().createQuery(
				"from UsersGroupList u where u.username = :username");

		query.setParameter("username", username);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList;

		else
			return null;
	}

	@Override
	public List<UsersGroupList> getUserGroupListByGroupId(String groupId) {
		List<UsersGroupList> grpList = new ArrayList<UsersGroupList>();

		Query query = openSession().createQuery(
				"from UsersGroupList u where u.groupid = :groupid");

		query.setParameter("groupid", groupId);

		grpList = query.list();

		if (grpList.size() > 0)
			return grpList;

		else
			return null;
	}

}

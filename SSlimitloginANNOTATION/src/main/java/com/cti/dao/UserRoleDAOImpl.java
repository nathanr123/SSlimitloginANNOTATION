/**
 * 
 */
package com.cti.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cti.model.UserRole;

/**
 * @author dharshini
 *
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cti.dao.UserRoleDAO#getRoleById(java.lang.String)
	 */
	@Override
	public UserRole getRoleById(String roleId) {
		UserRole usrRole = (UserRole) openSession().get(UserRole.class,
				roleId);
		return usrRole;
	}

}

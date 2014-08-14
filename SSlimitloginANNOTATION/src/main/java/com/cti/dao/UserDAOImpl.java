/**
 * 
 */
package com.cti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cti.model.User;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Override
	public void removeUser(String username) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, username);

		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}

	@Override
	public User getUserById(String username) {

		User user = (User) sessionFactory.getCurrentSession().get(User.class, username);

		System.out.println(user.getUsername());

		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession().getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
	}

}

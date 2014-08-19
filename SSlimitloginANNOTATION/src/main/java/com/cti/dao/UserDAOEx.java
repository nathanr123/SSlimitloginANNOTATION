/**
 * 
 */
package com.cti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cti.model.User;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class UserDAOEx implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		getCurrentSession().save(user);

	}

	@Override
	public void updateUser(User user) {
		getCurrentSession().update(user);

	}

	@Override
	public void removeUser(String username) {
		User user = (User) getCurrentSession().get(User.class, username);

		if (null != user) {
			getCurrentSession().delete(user);
		}

	}

	@Override
	public User getUserById(String username) {

		User user = (User) getCurrentSession().get(User.class, username);

		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void updatePassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		getCurrentSession().update(user);
	}

}
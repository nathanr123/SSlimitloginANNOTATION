package com.cti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cti.dao.UserDetailsDao;
import com.cti.model.UserAttempts;

@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	UserDetailsDao userDetailsDao;

	@Autowired
	@Qualifier("userDetailsService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
	
	@Autowired
	@Qualifier("passwordEncoder")	
	@Override
	public void setPasswordEncoder(Object passwordEncoder) {
			super.setPasswordEncoder(passwordEncoder);
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		try {

			Authentication auth = super.authenticate(authentication);

			// if reach here, means login success, else exception will be thrown
			// reset the user_attempts
			userDetailsDao.resetFailAttempts(authentication.getName());

			return auth;

		} catch (BadCredentialsException e) {

			// invalid login, update to user_attempts
			userDetailsDao.updateFailAttempts(authentication.getName());
			throw e;

		} catch (LockedException e) {

			// this user is locked!
			String error = "";

			UserAttempts userAttempts = userDetailsDao
					.getUserAttempts(authentication.getName());

			if (userAttempts != null) {
				error = "User account is locked! <br><br>Username : "
						+ authentication.getName() + "<br>Last Attempts : "
						+ userAttempts.getFormattedDate();
			} else {
				error = e.getMessage();
			}

			throw new LockedException(error);
		}

	}
	
	
}
/**
 * 
 */
package com.cti.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author nathanr_kamal
 *
 */
public class PasswordValidator implements
		ConstraintValidator<ValidPasswords, Object> {

	private String password;

	private String confirmPassword;

	@Override
	public void initialize(ValidPasswords paramA) {

		this.password = paramA.password();

		this.confirmPassword = paramA.confirmPassword();

	}

	@Override
	public boolean isValid(Object paramT,
			ConstraintValidatorContext paramConstraintValidatorContext) {

		try {
			Object passwrd = BeanUtils.getProperty(paramT, this.password);

			Object confirmPasswrd = BeanUtils.getProperty(paramT,
					this.confirmPassword);

			return passwrd == null && confirmPasswrd == null || passwrd != null
					&& passwrd.equals(confirmPasswrd);
		} catch (Exception e) {
			return false;
		}
	}

}

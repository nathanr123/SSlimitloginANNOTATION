/**
 * 
 */
package com.cti.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author nathanr_kamal
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPasswords {

	String message() default "{com.cti.validator.ValidPassword.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String password();

	String confirmPassword();

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		ValidPasswords[] value();
	}
}

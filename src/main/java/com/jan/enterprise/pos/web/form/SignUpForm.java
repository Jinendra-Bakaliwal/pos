/**
 * 
 */
package com.jan.enterprise.pos.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jan.enterprise.pos.validation.PasswordMatches;
import com.jan.enterprise.pos.validation.ValidEmail;
import com.jan.enterprise.pos.validation.ValidPassword;

import lombok.Data;

/**
 * @author Jinendra Jinendra Bakliwalwal
 *
 */
@Data
@PasswordMatches
public class SignUpForm {
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.firstName}")
	private String firstName;
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.lastName}")
	private String lastName;
	@NotNull
	private String mobile;
	@ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.signUpForm.email}")
	private String email;
	@NotNull
	private String shopName;
	@NotNull
	private String userName;
	@ValidPassword
	private String password;
	@NotNull
	@Size(min = 1)
	private String confirmPassword;
}

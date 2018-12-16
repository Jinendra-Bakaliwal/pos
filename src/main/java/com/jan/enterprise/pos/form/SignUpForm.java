/**
 * 
 */
package com.jan.enterprise.pos.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data
public class SignUpForm {
	@NotNull
    @Min(18)
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String mobile;
	@NotNull
	private String email;
	@NotNull
	private String shopName;
	@NotNull
	private String userName;
	@NotNull
	private String password;
	@NotNull
	private String confirmPassword;
}

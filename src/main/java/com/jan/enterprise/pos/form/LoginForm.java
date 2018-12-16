/**
 * 
 */
package com.jan.enterprise.pos.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author bakli
 *
 */
@Data
public class LoginForm {

	@NotNull
	private String userName;
	@NotNull
	private String password;
}

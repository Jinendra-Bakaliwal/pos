/**
 * 
 */
package com.jan.enterprise.pos.web.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data
public class LoginForm {

	@NotNull
	private String username;
	@NotNull
	private String password;
}

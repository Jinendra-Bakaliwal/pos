/**
 * 
 */
package com.jan.enterprise.pos.model;

import lombok.Data;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data
public class SignUpModel {
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String shopName;
	private String userName;
	private String password;
	private String confirmPassword;
}

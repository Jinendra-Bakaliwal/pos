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
 * @author Jinendra Bakliwal
 *
 */
@Data
@PasswordMatches
public class AccountSetupForm {
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.firstName}")
	private String firstName;
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.lastName}")
	private String lastName;
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.middleName}")
	private String middleName;
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.gender}")
	private String gender;
	@NotNull
	@Size(min = 1, message = "{Size.signUpForm.dob}")
	private String dob;
	@NotNull
	private String mobile;
	@ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.signUpForm.email}")
	private String email;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.addressLine1}")
	private String addressLine1;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.tehsil}")
	private String tehsil;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.district}")
	private String district;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.state}")
	private String state;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.zip}")
	private String zip;
	
	
	@NotNull
	private String shopName;
	@NotNull
	private String shopDisplayName;
	@ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopEmail}")
	private String shopEmail;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopMobile}")
	private String shopMobile;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopAddressLine1}")
	private String shopAddressLine1;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopTehsil}")
	private String shopTehsil;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopDistrict}")
	private String shopDistrict;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopState}")
	private String shopState;
	@NotNull
    @Size(min = 1, message = "{Size.signUpForm.shopZip}")
	private String shopZip;
	
	
}

package com.jan.enterprise.pos.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author bakli
 *
 */
@Data 
@EqualsAndHashCode (callSuper = false)
public class MemberModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int memberId;
	private String memberFirstName;
	private String memberLastName;
	private String memberMiddleName;
	private String username;
	private String password;
	private String addressLine1;
	private String tehsil;
	private String district;
	private String state;
	private String zip;
	private String mobile;
	private String email;
	private String notes;
	private int memberTypeId;
	private int shopId;
}

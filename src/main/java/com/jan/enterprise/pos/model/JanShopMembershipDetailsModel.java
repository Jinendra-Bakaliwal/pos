/**
 * 
 */
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
public class JanShopMembershipDetailsModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3739098290190097851L;
	private String shopMembershipTypeId;
	private String shopMembershipTypeDisplayName;
	private String shopMembershipType;
	private String maxAccountsAllowed;
	private String maxItemsAllowed;
	private String maxEmployeeAllowed;
	private String maxOwnerAllowed;
	private String notes;

}

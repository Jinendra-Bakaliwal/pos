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
/**
 * @author bakli
 *
 */
@Data 
@EqualsAndHashCode (callSuper = false)
public class ShopMasterModel extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3703750438622278359L;
	private String shopId;
	private String shopName;
	private String shopDisplayName;
	private String shopLogo;
	private String addressLine1;
	private String tehsil;
	private String district;
	private String zip;
	private String mobile;
	private String email;
	private String shopMembershipTypeId;
	private String status;
	private String notes;
}

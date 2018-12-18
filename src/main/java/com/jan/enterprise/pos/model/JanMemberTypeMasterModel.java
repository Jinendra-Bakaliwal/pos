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
public class JanMemberTypeMasterModel  extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5313223405228283404L;
	private String memberTypeId;
	private String memberType;
	private String memberTypeDisplayName;
	private String notes;
	private String status;
	private String shopId;


}

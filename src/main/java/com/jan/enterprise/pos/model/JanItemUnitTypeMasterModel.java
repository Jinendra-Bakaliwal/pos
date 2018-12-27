/**
 * 
 */
package com.jan.enterprise.pos.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data 
@EqualsAndHashCode (callSuper = false)
public class JanItemUnitTypeMasterModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1740105479577586692L;
	private String itemUnitTypeId;
	private String itemUnitType;
	private String itemUnitTypeDisplayName;
	private String notes;
	private String status;
	private String shopId;
}

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
public class JanTransactionTypeMasterModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5995546053700872374L;
	private String transactionTypeId;
	private String transactionType;
	private String transactionNature;
	private String shopId;
	private String notes;
}

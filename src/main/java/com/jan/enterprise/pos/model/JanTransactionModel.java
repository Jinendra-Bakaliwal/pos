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
public class JanTransactionModel  extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5380492063316174494L;
	private String transactionId ;
	private String itemActualPrice;
	private String itemSalePrice;
	private String quntity;
	private String totalPrice;
	private String notes;
}

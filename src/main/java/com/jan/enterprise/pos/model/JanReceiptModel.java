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
public class JanReceiptModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6023893281319172009L;
	private String receiptId;
	private String totalReceiptAmount;
	private String cash;
	private String credit;
	private String remark;
	private String totalActualReceiptAmount;
	private String shopId;
	private String transactionTypeId;
}

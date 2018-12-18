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
public class JanItemDetailModel  extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemId;
	private String itemName;
	private String itemDisplayName;
	private String itemWarningThreshold;
	private String barcode;
	private String itemImage;
	private String category;
	private String quantity;
	private String salePrice;
	private String notes;
	private String minSalePrice;
	private String maxSalePrice;
	private String purchasePrice;
	private String status;
	private String shopId;
	private String itemUnitTypeId;
}

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
public class JanItemMiscFieldModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4935309466794832622L;
	private String itemMiscFieldsId;
	private String manufacturer;
	private String quantity;
	private String companyRate;
	private String companyDiscountPercantage;
	private String discountPrice;
	private String totalPurchasePrice;
	private String toatalSalePrice;
	private String notes;
	private String itemId;

}

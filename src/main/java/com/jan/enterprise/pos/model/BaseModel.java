/**
 * 
 */
package com.jan.enterprise.pos.model;

import lombok.Data;

/**
 * @author bakli
 *
 */
@Data
public abstract class BaseModel {
	private String CreatedBy;
	private String CreatedDate;
	private int UpdatedBy;
	private String UpdatedDate;
}

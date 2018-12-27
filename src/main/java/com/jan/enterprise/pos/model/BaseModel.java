/**
 * 
 */
package com.jan.enterprise.pos.model;

import java.sql.Date;

import lombok.Data;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data
public abstract class BaseModel {
	private String Created_By;
	private Date Created_Date;
	private int Updated_By;
	private String Updated_Date;
}

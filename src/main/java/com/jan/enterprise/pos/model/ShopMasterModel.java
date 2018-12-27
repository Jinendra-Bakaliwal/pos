/**
 * 
 */
package com.jan.enterprise.pos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jinendra Bakliwal
 *
 */
/**
 * @author Jinendra Bakliwal
 *
 */
@Data 
@EqualsAndHashCode (callSuper = false)
@Entity
@Table(name = "shop_master")
public class ShopMasterModel extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3703750438622278359L;
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int shop_id;
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

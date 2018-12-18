/**
 * 
 */
package com.jan.enterprise.pos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jan.enterprise.pos.mapper.ShopRowMapper;
import com.jan.enterprise.pos.model.ShopMasterModel;

/**
 * @author bakli
 *
 */
@Transactional
@Repository
public class ShopRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Double d = 1.00d;
	public List<ShopMasterModel> getAllShpos() {
		   String sql = "SELECT shop_id FROM shop_master";
		   RowMapper<ShopMasterModel> rowMapper = new ShopRowMapper();
		   return this.jdbcTemplate.query(sql, rowMapper);
	} 
	
	public void saveShopInitial() {
		   String sql = "INSERT INTO jan_shop_membership_details (shop_membership_type_display_name, shop_membership_type, max_accounts_allowed, max_items_allowed, max_employee_allowed, max_owner_allowed, notes\r\n" + 
		   		") values (?, ?, ?, ?, ?, ?, ?)";

		   int i = jdbcTemplate.update(sql, "Jan", "Default", 1.00d, 1.00d, 1.00d, 1.00d, "notes");
		   System.out.println("-----------" + i);
//		   RowMapper<ShopMasterModel> rowMapper = new ShopRowMapper();
//		   return this.jdbcTemplate.query(sql, rowMapper);
		} 
}

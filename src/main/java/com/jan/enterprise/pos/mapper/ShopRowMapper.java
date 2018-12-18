/**
 * 
 */
package com.jan.enterprise.pos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jan.enterprise.pos.model.ShopMasterModel;

/**
 * @author bakli
 *
 */
public class ShopRowMapper implements RowMapper<ShopMasterModel> {
	   @Override
	   public ShopMasterModel mapRow(ResultSet row, int rowNum) throws SQLException {
		ShopMasterModel ShopMasterModel = new ShopMasterModel();
//		ShopMasterModel.setArticleId(row.getInt("articleId"));
//		ShopMasterModel.setTitle(row.getString("title"));
//		ShopMasterModel.setCategory(row.getString("category"));
	
		return ShopMasterModel;
	   }

}

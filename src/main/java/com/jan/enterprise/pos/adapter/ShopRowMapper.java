/**
 * 
 */
package com.jan.enterprise.pos.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jan.enterprise.pos.model.ShopModel;

/**
 * @author bakli
 *
 */
public class ShopRowMapper implements RowMapper<ShopModel> {
	   @Override
	   public ShopModel mapRow(ResultSet row, int rowNum) throws SQLException {
		ShopModel shopModel = new ShopModel();
//		shopModel.setArticleId(row.getInt("articleId"));
//		shopModel.setTitle(row.getString("title"));
//		shopModel.setCategory(row.getString("category"));
	
		return shopModel;
	   }

}

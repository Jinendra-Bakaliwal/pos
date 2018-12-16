/**
 * 
 */
package com.jan.enterprise.pos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bakli
 *
 */
@Transactional
@Repository
public class ShopRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}

/**
 * 
 */
package com.jan.enterprise.pos;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * @author bakli
 *
 */
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		return jdbcUserDetailsManager;
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest()
//				.fullyAuthenticated().and().formLogin().loginPage("/login")
//				.failureUrl("/login?error").permitAll().and().logout().permitAll();
//	}
}

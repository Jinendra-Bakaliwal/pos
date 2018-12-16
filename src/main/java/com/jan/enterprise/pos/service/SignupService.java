/**
 * 
 */
package com.jan.enterprise.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.enterprise.pos.form.SignUpForm;
import com.jan.enterprise.pos.repository.MemberRepository;
import com.jan.enterprise.pos.repository.ShopRepository;

/**
 * @author bakli
 *
 */
@Service
public class SignupService {

	/**
	 * 
	 */
	@Autowired
	private MemberRepository memberRepository;
	/**
	 * 
	 */
	@Autowired
	private ShopRepository shopRepository;
	
	public boolean signup(SignUpForm signUpModel) {
		return false;
	}

}

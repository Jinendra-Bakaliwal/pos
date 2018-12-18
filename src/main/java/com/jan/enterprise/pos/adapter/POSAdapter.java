/**
 * 
 */
package com.jan.enterprise.pos.adapter;

import org.springframework.stereotype.Component;

import com.jan.enterprise.pos.form.SignUpForm;
import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.ShopMasterModel;

/**
 * @author bakli
 *
 */
@Component
public class POSAdapter {

	public MemberModel getInitialMemberDetail(SignUpForm signUpForm) {
		MemberModel  memberModel = new MemberModel();
		memberModel.setMemberFirstName(signUpForm.getFirstName());
		memberModel.setMemberLastName(signUpForm.getLastName());
		memberModel.setUsername(signUpForm.getUserName());
		memberModel.setPassword(signUpForm.getPassword());
		memberModel.setEmail(signUpForm.getEmail());
		memberModel.setMobile(signUpForm.getMobile());
		return memberModel;
	}
	
	public ShopMasterModel getInitialShopDetail(SignUpForm signUpForm) {
		ShopMasterModel shopModel = new ShopMasterModel();
		shopModel.setShopName(signUpForm.getShopName());
		return shopModel;
	}

}

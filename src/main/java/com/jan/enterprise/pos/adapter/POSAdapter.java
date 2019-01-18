/**
 * 
 */
package com.jan.enterprise.pos.adapter;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.jan.enterprise.pos.web.util.POSConstants.STATUS_REGISTERED;
import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.Role;
import com.jan.enterprise.pos.model.ShopMasterModel;
import com.jan.enterprise.pos.model.VerificationToken;
import com.jan.enterprise.pos.web.form.AccountSetupForm;
import com.jan.enterprise.pos.web.form.SignUpForm;

/**
 * @author Jinendra Bakliwal
 *
 */
@Component
public class POSAdapter {
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	/**
	 * @param signUpForm
	 * @param shopMasterModel
	 * @param roleList
	 * @return
	 */
	public MemberModel populateInitialMemberDetail(SignUpForm signUpForm, ShopMasterModel shopMasterModel, List<Role> roleList) {
		MemberModel  memberModel = new MemberModel();
		memberModel.setMember_First_Name(signUpForm.getFirstName());
		memberModel.setMember_Last_Name(signUpForm.getLastName());
		memberModel.setUsername(signUpForm.getUserName()); 
		memberModel.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
		memberModel.setEmail(signUpForm.getEmail());
		memberModel.setMobile(signUpForm.getMobile());
		memberModel.setRoles(roleList);
		memberModel.setShopMasterModel(shopMasterModel);
		return memberModel;
	}
	
	/**
	 * @param signUpForm
	 * @return
	 */
	public ShopMasterModel populateInitialShopDetail(SignUpForm signUpForm) {
		ShopMasterModel shopModel = new ShopMasterModel();
		shopModel.setShopName(signUpForm.getShopName());
		shopModel.setStatus(STATUS_REGISTERED);
		shopModel.setCreated_By("Jan");
		shopModel.setCreated_Date(new Date(Calendar.getInstance().getTimeInMillis()));
		return shopModel;
	}
	
	public MemberModel populateCompleteMemberDetail(AccountSetupForm accountSetupForm, ShopMasterModel shopMasterModel, List<Role> roleList) {
		MemberModel  memberModel = new MemberModel();
		memberModel.setMember_First_Name(accountSetupForm.getFirstName());
		memberModel.setMember_Last_Name(accountSetupForm.getLastName());
//		memberModel.setUsername(accountSetupForm.getUserName()); 
//		memberModel.setPassword(passwordEncoder.encode(accountSetupForm.getPassword()));
		memberModel.setEmail(accountSetupForm.getEmail());
		memberModel.setMobile(accountSetupForm.getMobile());
		memberModel.setRoles(roleList);
		memberModel.setShopMasterModel(shopMasterModel);
		return memberModel;
	}
	
	public ShopMasterModel populateCompleteShopDetail(AccountSetupForm accountSetupForm) {
		ShopMasterModel shopModel = new ShopMasterModel();
		shopModel.setShopName(accountSetupForm.getShopName());
		shopModel.setStatus(STATUS_REGISTERED);
		shopModel.setCreated_By("Jan");
		shopModel.setCreated_Date(new Date(Calendar.getInstance().getTimeInMillis()));
		return shopModel;
	}

	public VerificationToken populateVarificationToken(MemberModel user, String token) {
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setMemberModel(user);
		verificationToken.setToken(token);
		return verificationToken;
	}


}

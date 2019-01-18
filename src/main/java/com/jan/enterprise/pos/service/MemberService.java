/**
 * 
 */
package com.jan.enterprise.pos.service;

import static com.jan.enterprise.pos.web.util.POSConstants.ROLE_REGISTERED_USER;
import static com.jan.enterprise.pos.web.util.POSConstants.TOKEN_EXPIRED;
import static com.jan.enterprise.pos.web.util.POSConstants.TOKEN_INVALID;
import static com.jan.enterprise.pos.web.util.POSConstants.TOKEN_VALID;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jan.enterprise.pos.adapter.POSAdapter;
import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.Role;
import com.jan.enterprise.pos.model.ShopMasterModel;
import com.jan.enterprise.pos.model.VerificationToken;
import com.jan.enterprise.pos.repository.MemberRepository;
import com.jan.enterprise.pos.repository.RoleRepository;
import com.jan.enterprise.pos.repository.ShopRepository;
import com.jan.enterprise.pos.repository.VerificationTokenRepository;
import com.jan.enterprise.pos.web.exception.UserAlreadyExistException;
import com.jan.enterprise.pos.web.form.AccountSetupForm;
import com.jan.enterprise.pos.web.form.SignUpForm;

/**
 * @author Jinendra Bakliwal
 *
 */
@Service
@Transactional
public class MemberService {

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
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private VerificationTokenRepository tokenRepository;
	
	@Autowired
	private POSAdapter adapter;
	
	public boolean signup(SignUpForm signUpForm) {
//		
//		shopRepository.initialSignup();
//		memberRepository.addInitialMemberdetail();
//		adapter.getInitialMemberDetail(signUpForm);
//		shopRepository.saveShopInitial();
		return false;
	}

	public MemberModel registerNewUserAccount(final SignUpForm signUpForm) {
        if (emailExist(signUpForm.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + signUpForm.getEmail());
        }
        ShopMasterModel masterModel = shopRepository.save(adapter.populateInitialShopDetail(signUpForm));
        List<Role> roleList = Arrays.asList(roleRepository.findByName(ROLE_REGISTERED_USER));
        return memberRepository.save(adapter.populateInitialMemberDetail(signUpForm, masterModel, roleList));
    }
	
	private boolean emailExist(final String email) {
        return memberRepository.findByEmail(email) != null;
    }
	
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final MemberModel user = verificationToken.getMemberModel();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
            .getTime()
            - cal.getTime()
                .getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setEnabled(true);
        tokenRepository.delete(verificationToken);
        memberRepository.save(user);
        return TOKEN_VALID;
    }
    
    public MemberModel getUser(final String verificationToken) {
        final VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.getMemberModel();
        }
        return null;
    }
    
    public MemberModel setupNewUserAccount(final AccountSetupForm accountSetupForm) {
        if (emailExist(accountSetupForm.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountSetupForm.getEmail());
        }
        ShopMasterModel masterModel = shopRepository.save(adapter.populateCompleteShopDetail(accountSetupForm));
        List<Role> roleList = Arrays.asList(roleRepository.findByName(ROLE_REGISTERED_USER));
        return memberRepository.save(adapter.populateCompleteMemberDetail(accountSetupForm, masterModel, roleList));
    }
}

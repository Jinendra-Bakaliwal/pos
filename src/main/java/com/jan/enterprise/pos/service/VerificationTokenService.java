/**
 * 
 */
package com.jan.enterprise.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jan.enterprise.pos.adapter.POSAdapter;
import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.VerificationToken;
import com.jan.enterprise.pos.repository.VerificationTokenRepository;

/**
 * @author Jinendra Bakliwal
 *
 */
@Transactional
@Service
public class VerificationTokenService {

  @Autowired
  private VerificationTokenRepository tokenRepository;
  
  @Autowired
  private POSAdapter posAdapter;
  
  public void createVerificationTokenForUser(final MemberModel user, final String token) {
      tokenRepository.save(posAdapter.populateVarificationToken(user, token));
  }
}

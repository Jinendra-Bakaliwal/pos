package com.jan.enterprise.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.enterprise.pos.model.MemberModel;
import com.jan.enterprise.pos.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

//    VerificationToken findByUser(MemberModel user);

//    Stream<VerificationToken> findAllByExpiryDateLessThan(Date now);
//
//    void deleteByExpiryDateLessThan(Date now);
//
//    @Modifying
//    @Query("delete from VerificationToken t where t.expiryDate <= ?1")
//    void deleteAllExpiredSince(Date now);
}

/**
 * 
 */
package com.jan.enterprise.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.enterprise.pos.model.MemberModel;

/**
 * @author Jinendra Bakliwal
 *
 */
public interface MemberRepository  extends JpaRepository<MemberModel, Long>{

	MemberModel findByEmail(String email);
}

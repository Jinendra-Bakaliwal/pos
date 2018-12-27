package com.jan.enterprise.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.enterprise.pos.model.MemberModel;

public interface UserRepository extends JpaRepository<MemberModel, Long> {
	MemberModel findByEmail(String email);

    @Override
    void delete(MemberModel user);

}

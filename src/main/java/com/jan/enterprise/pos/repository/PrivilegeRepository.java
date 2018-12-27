package com.jan.enterprise.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.enterprise.pos.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}

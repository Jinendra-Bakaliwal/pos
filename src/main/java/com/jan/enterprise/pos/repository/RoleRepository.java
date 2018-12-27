package com.jan.enterprise.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.enterprise.pos.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}

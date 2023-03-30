package com.uniwork.asssubsys.repository;


import com.uniwork.asssubsys.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
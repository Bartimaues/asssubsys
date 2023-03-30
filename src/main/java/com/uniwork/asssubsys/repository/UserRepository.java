package com.uniwork.asssubsys.repository;

import com.uniwork.asssubsys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
package com.dgs.springbootsecurityroles.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.springbootsecurityroles.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String username);
}

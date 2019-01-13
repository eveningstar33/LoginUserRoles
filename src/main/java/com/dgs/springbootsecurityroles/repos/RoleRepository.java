package com.dgs.springbootsecurityroles.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.springbootsecurityroles.entity.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
}

package com.dgs.springbootsecurityroles.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.springbootsecurityroles.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

package com.dgs.springbootsecurityroles.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.springbootsecurityroles.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}

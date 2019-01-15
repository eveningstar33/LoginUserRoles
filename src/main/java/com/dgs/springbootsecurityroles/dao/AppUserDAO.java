package com.dgs.springbootsecurityroles.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dgs.springbootsecurityroles.entity.AppUser;

@Repository
@Transactional
public class AppUserDAO {

	@Autowired
	private EntityManager entityManager;
	
	public AppUser findUserAccount(String username) {
		System.out.println(">>>>>>>>>>><<<<<<<<<<<< Inside AppUserDAO findUserAccount()"); 
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " 
					+ " Where e.username = :username ";		// These are not from the tables, they are from the entity classes	
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("username", username);
			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

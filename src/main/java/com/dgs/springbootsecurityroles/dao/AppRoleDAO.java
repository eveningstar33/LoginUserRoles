package com.dgs.springbootsecurityroles.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dgs.springbootsecurityroles.entity.UserRole;

@Repository
@Transactional
public class AppRoleDAO {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<String> getRoleNames(Long userId) {
			String sql = "Select ur.appRole.name from " + UserRole.class.getName() + " ur "
					+ " where ur.appUser.id = :userId ";         // These are not from the tables, they are from the entity classes
			Query query = entityManager.createQuery(sql, String.class);
			query.setParameter("userId", userId); 
			return (List<String>) query.getResultList();
	}
	
}

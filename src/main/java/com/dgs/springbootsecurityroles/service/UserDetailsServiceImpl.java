package com.dgs.springbootsecurityroles.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dgs.springbootsecurityroles.dao.AppRoleDAO;
import com.dgs.springbootsecurityroles.dao.AppUserDAO;
import com.dgs.springbootsecurityroles.entity.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AppUserDAO appUserDAO;
	
	@Autowired
	private AppRoleDAO appRoleDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserDAO.findUserAccount(username);
		if (appUser == null) {
			System.out.println("User not found: " + username); 
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		System.out.println("Found User: " + username);
		List<String> roleNames = appRoleDAO.getRoleNames(appUser.getId());
		
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role: roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantedList.add(authority);
			}
		}
		UserDetails userDetails = new User(appUser.getUsername(), appUser.getPassword(), grantedList);
		
		return userDetails;
	}
}

package com.ibm.jwt.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.jwt.dao.RoleDao;
import com.ibm.jwt.dao.UserDao;
import com.ibm.jwt.entity.User;
import com.ibm.jwt.entity.Role;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	public User registerNewuser(User user) {
		return userDao.save(user);
	}

	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);

		Role userRole =new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default for user");
		roleDao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword("admin@pass");
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
		User user=new User();
		user.setUserFirstName("Dhruv");
		user.setUserLastName("Dey");
		user.setUserName("dhruvdey0907");
		user.setUserPassword("dhruv");
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userDao.save(user);
	}
	
//	 public User registerNewUser(User user) {
//	        Role role = roleDao.findById("User").get();
//	        Set<Role> userRoles = new HashSet<>();
//	        userRoles.add(role);
//	        user.setRole(userRoles);
//	        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//
//	        return userDao.save(user);
//	    }
//
//	    public String getEncodedPassword(String password) {
//	        return passwordEncoder.encode(password);
//	    }

}

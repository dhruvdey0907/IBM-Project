package com.ibm.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ecommerce.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}

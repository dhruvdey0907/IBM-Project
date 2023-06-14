package com.ibm.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ecommerce.entity.Cart;
import com.ibm.ecommerce.entity.User;

@Repository
public interface CartDao extends CrudRepository <Cart,Integer>{
	   public List<Cart> findByUser(User user);
}

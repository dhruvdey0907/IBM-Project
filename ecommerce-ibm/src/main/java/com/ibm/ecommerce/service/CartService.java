package com.ibm.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ecommerce.configuration.JwtRequestFilter;
import com.ibm.ecommerce.dao.CartDao;
import com.ibm.ecommerce.dao.ProductDao;
import com.ibm.ecommerce.dao.UserDao;
import com.ibm.ecommerce.entity.Cart;
import com.ibm.ecommerce.entity.Product;
import com.ibm.ecommerce.entity.User;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
public Cart addToCart(Integer productId) {
	Product product=productDao.findById(productId).get();
	String username=JwtRequestFilter.CURRENT_USER;
	User user=null;
	if(username!=null) {
		 user=userDao.findById(username).get();
	}
	if(product !=null && user!=null) {
		Cart cart=new Cart(product,user);
		cartDao.save(cart);
	}
	 user =userDao.findById(username).get();
	if(product!=null) {
		
	}
	return null;
}
}

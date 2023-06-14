package com.ibm.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ecommerce.entity.Cart;

@Repository
public interface CartDao extends CrudRepository <Cart,Integer>{

}

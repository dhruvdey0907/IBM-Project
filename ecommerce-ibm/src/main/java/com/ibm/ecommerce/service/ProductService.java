package com.ibm.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ecommerce.dao.ProductDao;
import com.ibm.ecommerce.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}

}

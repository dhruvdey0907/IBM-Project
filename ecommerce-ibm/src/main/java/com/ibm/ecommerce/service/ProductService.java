package com.ibm.ecommerce.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibm.ecommerce.configuration.JwtRequestFilter;
import com.ibm.ecommerce.dao.ProductDao;
import com.ibm.ecommerce.entity.Product;
import com.ibm.ecommerce.entity.User;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}
public List<Product> getAllProducts(int pageNumber,String searchKey){
	Pageable pageable=PageRequest.of(pageNumber,size:12);
	if (searchKey.equals("")) {
		return (List<Product>)productDao.findAll(pageable);
	
	}
	else {
		return (List<Product>)productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(searchKey, searchKey, pageable);
	}
	
	
}
public Product getDetailsById(Integer productId) {
	 return productDao.findById(productId).get();
}
public void deleteProductDetails(Integer productId) {
	productDao.deleteById(productId);
}
public Product getProductDetailsById(Integer productId) {
	// TODO Auto-generated method stub
	return null;
}
public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
    if(isSingleProductCheckout && productId != 0) {
        // we are going to buy a single product

        List<Product> list = new ArrayList<>();
        Product product = productDao.findById(productId).get();
        list.add(product);
        return list;
    } else {
        // we are going to checkout entire cart
//        String username = JwtRequestFilter.CURRENT_USER;
//        User user = userDao.findById(username).get();
//        List<Cart> carts = cartDao.findByUser(user);

        return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
    }
}
}

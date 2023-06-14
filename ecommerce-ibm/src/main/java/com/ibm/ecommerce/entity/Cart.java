package com.ibm.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer CardId;
	@OneToOne
	private Product product;
	@OneToOne
	private User user;
	
	public Cart() {
		
	}
	public Integer getCardId() {
		return CardId;
	}
	public void setCardId(Integer cardId) {
		CardId = cardId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public Cart(Product product, User user) {
		this.product = product;
		this.user = user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}

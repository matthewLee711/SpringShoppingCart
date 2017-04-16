package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart_table")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	public Integer cart_id;
	
	@ManyToOne
	@Column(name="name")
	public Product item_fk;
	
	@Column(name="number_to_purchase")
	public Integer numToPurchase;
	
	@ManyToOne
	@Column(name="buyer_fk")
	public User buyer_fk;
	
	public void cartItemInsertion(User user, Product product) {
		this.buyer_fk = user;
		this.item_fk = product;
		this.numToPurchase = 1;
	}
	
}

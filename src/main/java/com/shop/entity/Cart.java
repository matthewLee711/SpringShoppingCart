package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart_table")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	public Integer cart_id;
	
	@ManyToOne
	@JoinColumn(name="item_fk")
	public Product item_fk;
	
	@Column(name="number_to_purchase")
	public Integer numToPurchase;
	
	@ManyToOne
	@JoinColumn(name="buyer_fk")
	public User buyer_fk;
	
	public void cartItemInsertion(User buyer, Product product) {
		this.buyer_fk = buyer;
		this.item_fk = product;
		this.numToPurchase = 1;
	}
	
	public Cart() { }
	
}

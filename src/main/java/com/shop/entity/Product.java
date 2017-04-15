package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	public Integer itemID;
	
	@Column(name="name")
	public String name;
	
	@Column(name="description")
	public String description;
	
	@Column(name="price")
	public Integer price;
	
	@Column(name="stock")
	public Integer stock;
}

//@Entity
//@Table(name="Product")
//public class Product {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ProductID")
//	private Integer itemID;
//	
//	@Column(name="Name")
//	private String name;
//	
//	@Column(name="Description")
//	public String description;
//	
//	@Column(name="Price")
//	public Integer price;
//	
//	@Column(name="Stock")
//	private Integer stock;
//}
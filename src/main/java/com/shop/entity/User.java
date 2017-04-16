package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	public Integer user_id;
	
	@Column(name="name")
	public String username;
	
	@Column(name="name")
	public String password;
	
	@Column(name="name")
	public Integer user_type_fk;
	
}

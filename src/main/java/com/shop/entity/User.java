package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	public Integer user_id;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	public String password;
	
//	@ManyToOne
//	@JoinColumn(name="user_type_fk")
//	public UserType user_type_fk;//THIS MIGHT POS BIG PROBLEMS
	
	@Column(name="user_type_fk")
	public Integer user_type_fk;//THIS MIGHT POS BIG PROBLEMS
	
	public User() { }
}

package com.shop.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.shop.entity.Cart;
import com.shop.entity.HibernateUtil;
import com.shop.entity.Product;
import com.shop.entity.User;

public class CartDAO {
	public List<Cart> getCart(String user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//Get user id object
		Query<User> userid = session.createQuery("FROM User WHERE username = :username");
		userid.setParameter("username", user);	
		User id = userid.getSingleResult();
		
		//Get cart based on user id
		Query<Cart> q = session.createQuery("FROM Cart WHERE buyer_fk = :buyer");
		userid.setParameter("buyer", id);
		
		List<Cart> cartItems = new ArrayList<Cart>();
		Iterator<Cart> iter = q.getResultList().iterator();
		while(iter.hasNext()) {
			cartItems.add(iter.next());
		}
		session.getTransaction().commit();
		return cartItems;
	}
	
	//THE purpose of services is to hide a lot of the implementation details
	//Need to implement a a cart checker.
	
	public void addNewItemToCart(String user, String item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//Get user obj (has id with it)
		Query<User> userid = session.createQuery("FROM User WHERE username = :username");
		userid.setParameter("username", user);	
		User user_id = userid.getSingleResult();
		//Get product obj 
		Query<Product> productid = session.createQuery("FROM Product WHERE name = :product");
		productid.setParameter("product", item);	
		Product item_id = productid.getSingleResult(); 
		//Insert into DB
		Cart addItem = new Cart();
		addItem.cartItemInsertion(user_id, item_id);
		session.persist(addItem);
		session.getTransaction().commit();
	}
}

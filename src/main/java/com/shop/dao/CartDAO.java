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
		userid.setParameter("username", "user");	
		User id = userid.getSingleResult();
		
		//Get cart based on user id
		Query<Cart> q = session.createQuery("FROM Cart WHERE buyer_fk = :buyer");
		q.setParameter("buyer", id);
		
		List<Cart> cartItems = new ArrayList<Cart>();
		Iterator<Cart> iter = q.getResultList().iterator();
		while(iter.hasNext()) {
			cartItems.add(iter.next());
		}
		session.getTransaction().commit();
		return cartItems;
	}
	
	public void deleteCartItem(String item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//Get product obj for adding back cart stock to product stock
		Query<Product> productid = session.createQuery("FROM Product WHERE name = :product");
		productid.setParameter("product", item);	
		Product item_id = productid.getSingleResult();

		//Remove Cart Item and update product stock
		Query<Cart> q = session.createQuery("FROM Cart WHERE item_fk = :item");
		q.setParameter("item", item_id);
		Cart deleteItem = q.getSingleResult();
		Integer returnStock = deleteItem.numToPurchase;
		item_id.stock += returnStock;
		session.update(item_id);
		session.delete(deleteItem);
		session.update(item_id);
		session.getTransaction().commit();
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
		
		//Get product obj and remove from product stock
		Query<Product> productid = session.createQuery("FROM Product WHERE name = :product");
		productid.setParameter("product", item);	
		Product item_id = productid.getSingleResult();
		item_id.stock -= 1;
		session.update(item_id);
		
		//Check if item already in db
		if(updateCartStock(session, user_id, item_id)) {
			System.out.println("updating");
			//update the stock with + 1
			Query<Cart> updateStock = session.createQuery("FROM Cart WHERE item_fk = :product AND buyer_fk = :user");
			updateStock.setParameter("product", item_id);
			updateStock.setParameter("user", user_id);
			Cart update = updateStock.getSingleResult();
			update.numToPurchase += 1;
			session.update(update);
			session.getTransaction().commit();
		} else {
			System.out.println("adding to db");
			//Insert new item into cart
			Cart addItem = new Cart();
			addItem.cartItemInsertion(user_id, item_id);
			session.persist(addItem);
			session.getTransaction().commit();
		}
	}
	
	//Check if there is another item in the shopping cart
	public boolean updateCartStock(Session session, User user, Product item) {
		Query<Cart> checkExists = session.createQuery("FROM Cart WHERE item_fk = :product AND buyer_fk = :user");
		checkExists.setParameter("product", item);
		checkExists.setParameter("user", user);
		Iterator<Cart> iter = checkExists.getResultList().iterator();

		//if item already in cart, return true
		if(checkExists.getResultList().size() >= 1) {
			return true;
		} else {
			return false;
		}
	}
}

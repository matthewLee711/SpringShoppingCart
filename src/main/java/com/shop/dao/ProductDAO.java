package com.shop.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.shop.entity.HibernateUtil;
import com.shop.entity.Product;

public class ProductDAO {
	public List<Product> getProducts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Product> q = session.createQuery("FROM Product");
		List<Product> result = new ArrayList<Product>();
		Iterator<Product> iter = q.getResultList().iterator();
		while(iter.hasNext()) {
			result.add(iter.next());
		}
		session.getTransaction().commit();
		return result;
	}
	
	public void addToCart(Product item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//pass item name, add product to cart
		//set stock to 1
		//pass in user name too
		
		session.getTransaction().commit();
	}
	
	public void purchaseProduct(Product purchase) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//When item is purchased, remove from shopping cart table
		
		session.getTransaction().commit();
	}
}

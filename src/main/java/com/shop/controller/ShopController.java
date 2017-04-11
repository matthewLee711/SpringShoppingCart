package com.shop.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dao.ProductDAO;
import com.shop.entity.Product;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/items", method= RequestMethod.GET)
	public String getProducts() {
		ProductDAO getProducts = new ProductDAO();
		ObjectMapper mapper = new ObjectMapper();
		String listToJson = null;
		try {
			listToJson = mapper.writeValueAsString(getProducts.getProducts());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listToJson;
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/purchase", method= RequestMethod.POST)
	public String purchaseItem() {
		
		return null;
	}
}

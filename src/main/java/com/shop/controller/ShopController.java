package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/items", method= RequestMethod.GET)
	public String getShopItems() {
		
		return null;
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/purchase", method= RequestMethod.POST)
	public String purchaseItem() {
		
		return null;
	}
}

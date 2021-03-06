package com.shop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dao.CartDAO;
import org.json.*;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/getCart", method= RequestMethod.GET)
	public @ResponseBody String getCart(@RequestParam(value="user") String username) {
		System.out.println("Recieved it");
		System.out.print(username);
		CartDAO getCartItems = new CartDAO();
		ObjectMapper mapper = new ObjectMapper();
		String listToJson = null;
		try {
			listToJson = mapper.writeValueAsString(getCartItems.getCart(username));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listToJson;
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/addToCart", method= RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestBody String data) {
		JSONObject obj;
		String user = null;
		String item = null;
		try {
			obj = new JSONObject(data);
			user = obj.getString("user");
			item = obj.getString("item_name");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(user);
		System.out.println(item);
		//Create service which will abstract insertion
		CartDAO addCartItem = new CartDAO();
		addCartItem.addNewItemToCart("user", item);
		return null;
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="false")
	@RequestMapping(value="/deleteCartItem", method= RequestMethod.DELETE)
	public @ResponseBody void deleteItemCart(@RequestParam(value="item") String item) {
		System.out.println("Delete it");
		System.out.println(item);
		CartDAO cartItems = new CartDAO();
		cartItems.deleteCartItem(item);
	}
}

package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.service.services.interfaces.IRestaurantService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/restaurants")
public class RestaurantController {

	private IRestaurantService restaurantService;

	@Autowired
	public RestaurantController(IRestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
}
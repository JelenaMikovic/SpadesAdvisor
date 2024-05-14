package com.ftn.sbnz.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.service.dtos.RestaurantFilterDTO;
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

	@GetMapping("/filtered")
    public List<Restaurant> getFilteredRestaurants(@RequestBody RestaurantFilterDTO filterDTO) {
        return restaurantService.getFilteredRestaurants(filterDTO);
    }

	@GetMapping("/search")
    public List<Restaurant> searchRestaurantsByName(@RequestParam String name) {
        return restaurantService.searchRestaurantsByName(name);
    }
}
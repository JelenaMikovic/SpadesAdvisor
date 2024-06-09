package com.ftn.sbnz.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.service.dtos.RestaurantDTO;
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

	@PostMapping("/filtered")
    public List<Restaurant> getFilteredRestaurants(@RequestBody RestaurantFilterDTO filterDTO) {
        return restaurantService.getFilteredRestaurants(filterDTO);
    }

	@GetMapping("/search")
    public List<Restaurant> searchRestaurantsByName(@RequestParam String name) {
        return restaurantService.searchRestaurantsByName(name);
    }

    @PostMapping("/addToFavourites")
    public Boolean addToFavorites(@PathVariable Long idRestaurant, @SessionAttribute("userId") Long userId){
        return restaurantService.addFavoriteRestaurant(idRestaurant, userId);        
    }

    @PostMapping("/addRestaurant")
    public Boolean addRestaurany(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.addRestaurant(restaurantDTO);
    }

 
}
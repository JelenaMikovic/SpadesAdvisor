package com.ftn.sbnz.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.service.dtos.RestaurantFilterDTO;
import com.ftn.sbnz.service.repositories.RestaurantRepository;
import com.ftn.sbnz.service.services.interfaces.IRestaurantService;

@Service
public class RestaurantService implements IRestaurantService{
    
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(RestaurantFilterDTO filterDTO) {
        if (filterDTO == null) {
            return restaurantRepository.findAll();
        } else {
            return restaurantRepository.findFilteredRestaurants(
                    filterDTO.getMinPrice(),
                    filterDTO.getMaxPrice(),
                    filterDTO.getVegetarianFriendly(),
                    filterDTO.getSmokerFriendly(),
                    filterDTO.getLocation(),
                    filterDTO.getCuisineType(),
                    filterDTO.getMinAvgRating());
        }
    }

    @Override
    public List<Restaurant> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name);
    }
    
}

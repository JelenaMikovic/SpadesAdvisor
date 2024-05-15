package com.ftn.sbnz.service.services.interfaces;

import java.util.List;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.service.dtos.RestaurantFilterDTO;

public interface IRestaurantService {

    List<Restaurant> getFilteredRestaurants(RestaurantFilterDTO filterDTO);

    List<Restaurant> searchRestaurantsByName(String name);

    List<Restaurant> getRecommendedRestaurants(RestaurantFilterDTO filterDTO);
    
}

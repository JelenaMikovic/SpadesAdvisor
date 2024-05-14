package com.ftn.sbnz.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.service.repositories.RestaurantRepository;
import com.ftn.sbnz.service.services.interfaces.IRestaurantService;

@Service
public class RestaurantService implements IRestaurantService{
    
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
}

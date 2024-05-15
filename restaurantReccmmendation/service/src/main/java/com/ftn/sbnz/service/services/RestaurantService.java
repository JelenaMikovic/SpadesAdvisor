package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.service.dtos.RestaurantFilterDTO;
import com.ftn.sbnz.service.repositories.RestaurantRepository;
import com.ftn.sbnz.service.services.interfaces.IRestaurantService;

@Service
public class RestaurantService implements IRestaurantService{
    
    private RestaurantRepository restaurantRepository;
    private final KieContainer kieContainer;


    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, KieContainer kieContainer) {
        this.restaurantRepository = restaurantRepository;
        this.kieContainer = kieContainer;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(RestaurantFilterDTO filterDTO) {
        if (filterDTO == null) {
            return restaurantRepository.findAll();
        } else {
            return restaurantRepository.findFilteredRestaurants(
                    filterDTO.getMinPrice(),
                    filterDTO.getMaxPrice(),
                    filterDTO.getIsVegetarianFriendly(),
                    filterDTO.getIsSmokerFriendly(),
                    filterDTO.getLocation(),
                    filterDTO.getCuisineType(),
                    filterDTO.getMinAvgRating());
        }
    }

    @Override 
    public List<Restaurant> getRecommendedRestaurants(RestaurantFilterDTO filterDTO) {
        
        List<Restaurant> recommendations = new ArrayList<>();
        
        KieSession kieSession = kieContainer.newKieSession("basicKsession");

        System.out.println(kieSession);
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(filterDTO);


        for(Restaurant restaurant: restaurantRepository.findAll()) {
            kieSession.insert(restaurant);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
        return recommendations;
    }

    @Override
    public List<Restaurant> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name);
    }
    
}

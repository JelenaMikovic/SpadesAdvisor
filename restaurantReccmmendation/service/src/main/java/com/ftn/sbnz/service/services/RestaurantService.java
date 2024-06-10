package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.service.dtos.ReccomendationsDTO;
import com.ftn.sbnz.service.dtos.RestaurantDTO;
import com.ftn.sbnz.service.dtos.RestaurantFilterDTO;
import com.ftn.sbnz.service.repositories.RestaurantRepository;
import com.ftn.sbnz.service.repositories.ReviewRepository;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.interfaces.IRestaurantService;
import com.ftn.sbnz.model.models.User;


@Service
public class RestaurantService implements IRestaurantService{
    
    private RestaurantRepository restaurantRepository;
    private final KieContainer kieContainer;
    private UserRepository userRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, KieContainer kieContainer, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.kieContainer = kieContainer;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override 
    public List<Restaurant> getFilteredRestaurants(RestaurantFilterDTO filterDTO) {
        
        List<Restaurant> recommendations = new ArrayList<>();
        
        KieSession kieSession = kieContainer.newKieSession("basicKsession");

        System.out.println(filterDTO.getCuisineType());
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(filterDTO);


        for(Restaurant restaurant: restaurantRepository.findAll()) {
            kieSession.insert(restaurant);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
        List<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant r: recommendations){
            r.setReviews(null);
            restaurants.add(r);
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> searchRestaurantsByName(String name) {
        List<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant r: restaurantRepository.findByNameContainingIgnoreCase(name)){
            r.setReviews(null);
            restaurants.add(r);
        }
        return restaurants;
    }

    @Override
    public Boolean addFavoriteRestaurant(Long restaurantId, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Korisnik sa datim ID-em nije pronađen.");
        }
        // Provera da li postoji restoran
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new IllegalArgumentException("Restoran sa datim ID-em nije pronađen.");
        }
        // Dodavanje restorana u listu omiljenih restorana korisnika
        User user = userOptional.get();
        Restaurant restaurant = restaurantOptional.get();
        user.getFavoriteRestaurants().add(restaurant);
        userRepository.save(user); // Čuvanje promena
        return true;
    }

    @Override
    public Boolean addRestaurant(RestaurantDTO restaurantDTO) {
                // Kreiranje instance restorana na osnovu DTO objekta
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCuisineType(restaurantDTO.getCuisineType());
        restaurant.setLocation(restaurantDTO.getLocation());
        restaurant.setPrice(restaurantDTO.getPrice());
        restaurant.setOpeningHour(restaurantDTO.getOpeningHour());
        restaurant.setClosingHour(restaurantDTO.getClosingHour());
        restaurant.setVegetarianFriendly(restaurantDTO.getIsVegetarianFriendly());
        restaurant.setSmokerFriendly(restaurantDTO.getIsSmokerFriendly());
        // Dodatne postavke restorana ako postoje

        // Čuvanje restorana u bazi podataka
        restaurantRepository.save(restaurant);

        return true;
    }

    @Override 
    public ReccomendationsDTO getReccomendedRestaurants(Long userId) {
        List<Restaurant> recommendedRestaurantsRating = new ArrayList<>();
        List<Restaurant> recommendedRestaurantsLocation = new ArrayList<>();
        Map<String, Integer> locationVisitCounts = new HashMap<>();

        KieSession kieSession = kieContainer.newKieSession("forwardKsession");

        kieSession.setGlobal("recommendedRestaurantsLocation", recommendedRestaurantsLocation);
        kieSession.setGlobal("locationVisitCounts", locationVisitCounts);
        kieSession.setGlobal("recommendedRestaurantsRating", recommendedRestaurantsRating);

        
        User user = userRepository.findById(userId).get();
        kieSession.insert(user);

        for(Restaurant restaurant: restaurantRepository.findAll()) {
            kieSession.insert(restaurant);
        }

        for(Review review: reviewRepository.findAll()) {
            kieSession.insert(review);
        }

        kieSession.fireAllRules();
        kieSession.dispose();

        ReccomendationsDTO dto = new ReccomendationsDTO();

        List<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant r: recommendedRestaurantsLocation){
            r.setReviews(null);
            restaurants.add(r);
        }
        dto.setRecommendedRestaurantsLocation(restaurants);

        restaurants = new ArrayList<>();
        for(Restaurant r: recommendedRestaurantsRating){
            r.setReviews(null);
            restaurants.add(r);
        }
        dto.setRecommendedRestaurantsRating(restaurants);

        return dto;
    }

}

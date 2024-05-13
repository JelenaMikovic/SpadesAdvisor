package com.ftn.sbnz.service;

import java.util.ArrayList;
import java.util.List;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.TrendingRestaurantsConditionsTemplate;

public class RestaurantRecommendationService {

    public static List<Restaurant> findTrendingRestaurants(List<Restaurant> restaurants, TrendingRestaurantsConditionsTemplate template) {
        List<Restaurant> trendingRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            restaurant.setTrending(false);
            if (restaurant.getCuisineType() == template.getCuisineType() &&
                restaurant.getReviews().size() >= template.getMinReviews() &&
                restaurant.getAverageRating() >= template.getMinRating()) {
                restaurant.setTrending(true); 
                trendingRestaurants.add(restaurant);
            }
        }

        return trendingRestaurants;
    }
}
package com.ftn.sbnz.service.dtos;

import java.util.List;
import com.ftn.sbnz.model.models.Restaurant;

public class ReccomendationsDTO {
    private List<Restaurant> recommendedRestaurantsRating;
    private List<Restaurant> recommendedRestaurantsLocation;

    public List<Restaurant> getRecommendedRestaurantsRating() {
        return recommendedRestaurantsRating;
    }

    public void setRecommendedRestaurantsRating(List<Restaurant> recommendedRestaurantsRating) {
        this.recommendedRestaurantsRating = recommendedRestaurantsRating;
    }

    public List<Restaurant> getRecommendedRestaurantsLocation() {
        return recommendedRestaurantsLocation;
    }

    public void setRecommendedRestaurantsLocation(List<Restaurant> recommendedRestaurantsLocation) {
        this.recommendedRestaurantsLocation = recommendedRestaurantsLocation;
    }
}

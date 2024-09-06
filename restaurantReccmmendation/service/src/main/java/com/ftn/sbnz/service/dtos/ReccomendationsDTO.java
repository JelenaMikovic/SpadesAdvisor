package com.ftn.sbnz.service.dtos;

import java.util.List;
import com.ftn.sbnz.model.models.Restaurant;

public class ReccomendationsDTO {
    private List<Restaurant> recommendedRestaurantsRating;
    private List<Restaurant> recommendedRestaurantsLocation;
    private List<Restaurant> recommendedRestaurantsPrice;
    private List<Restaurant> recommendedRestaurantsWorkingHours;

    public List<Restaurant> getRecommendedRestaurantsPrice() {
        return recommendedRestaurantsPrice;
    }

    public void setRecommendedRestaurantsPrice(List<Restaurant> recommendedRestaurantsPrice) {
        this.recommendedRestaurantsPrice = recommendedRestaurantsPrice;
    }

    public List<Restaurant> getRecommendedRestaurantsWorkingHours() {
        return recommendedRestaurantsWorkingHours;
    }

    public void setRecommendedRestaurantsWorkingHours(List<Restaurant> recommendedRestaurantsWorkingHours) {
        this.recommendedRestaurantsWorkingHours = recommendedRestaurantsWorkingHours;
    }

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

package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.models.CuisineType;

public class RestaurantFilterDTO {

    private Double minPrice;
    private Double maxPrice;
    private Boolean isVegetarianFriendly;
    private Boolean isSmokerFriendly;
    private String location;
    private CuisineType cuisineType;
    private Double minAvgRating;

    // Getters
    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public Boolean getIsVegetarianFriendly() {
        return isVegetarianFriendly;
    }

    public Boolean getIsSmokerFriendly() {
        return isSmokerFriendly;
    }

    public String getLocation() {
        return location;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public Double getMinAvgRating() {
        return minAvgRating;
    }

    // Setters
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setVegetarianFriendly(Boolean vegetarianFriendly) {
        isVegetarianFriendly = vegetarianFriendly;
    }

    public void setSmokerFriendly(Boolean smokerFriendly) {
        isSmokerFriendly = smokerFriendly;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setMinAvgRating(Double minAvgRating) {
        this.minAvgRating = minAvgRating;
    }

}

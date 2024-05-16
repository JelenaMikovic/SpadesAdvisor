package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.models.CuisineType;

public class RestaurantDTO {
    private String name;
    private CuisineType cuisineType;
    private String location;
    private double price;
    private String openingHour;
    private String closingHour;
    private Boolean isVegetarianFriendly;
    private Boolean isSmokerFriendly;

    public RestaurantDTO(String name, CuisineType cuisineType, String location, double price, String openingHour,
            String closingHour, Boolean isVegetarianFriendly, Boolean isSmokerFriendly) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.isVegetarianFriendly = isVegetarianFriendly;
        this.isSmokerFriendly = isSmokerFriendly;
    }

    public RestaurantDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public Boolean getIsVegetarianFriendly() {
        return isVegetarianFriendly;
    }

    public void setIsVegetarianFriendly(Boolean isVegetarianFriendly) {
        this.isVegetarianFriendly = isVegetarianFriendly;
    }

    public Boolean getIsSmokerFriendly() {
        return isSmokerFriendly;
    }

    public void setIsSmokerFriendly(Boolean isSmokerFriendly) {
        this.isSmokerFriendly = isSmokerFriendly;
    }

}

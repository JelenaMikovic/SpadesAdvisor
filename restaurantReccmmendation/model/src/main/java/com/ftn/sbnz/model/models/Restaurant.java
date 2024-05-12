package com.ftn.sbnz.model.models;

public class Restaurant {
    
    private long id;
    private CuisineType cuisineType;
    private String location;
    private double price;
    private String openingHour;
    private String closingHour;

    public Restaurant(long id, CuisineType cuisineType, String location, double price, String openingHour, String closingHour) {
        this.id = id;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

}
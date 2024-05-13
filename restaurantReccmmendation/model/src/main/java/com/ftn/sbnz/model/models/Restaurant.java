package com.ftn.sbnz.model.models;

import java.util.ArrayList;

public class Restaurant {
    
    private long id;
    private CuisineType cuisineType;
    private String location;
    private double price;
    private String openingHour;
    private String closingHour;
    private ArrayList<Review> reviews;

    public Restaurant(long id, CuisineType cuisineType, String location, double price, String openingHour, String closingHour) {
        this.id = id;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.reviews = new ArrayList<>();
    }

}
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

    public void addReview(Review review) {
        reviews.add(review);
    }

    // Getters
    public long getId() {
        return id;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}

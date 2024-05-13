package com.ftn.sbnz.model.models;

import java.util.ArrayList;

public class Restaurant {
    
    private long id;
    private String name;
    private CuisineType cuisineType;
    private String location;
    private double price;
    private String openingHour;
    private String closingHour;
    private ArrayList<Review> reviews;
    private boolean isTrending;

    public Restaurant(long id, String name, CuisineType cuisineType, String location, double price, String openingHour, String closingHour) {
        this.id = id;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.reviews = new ArrayList<>();
        this.isTrending = false;
        this.name = name;
    }

    public Restaurant(long id, String name, CuisineType cuisineType, String location, double price, String openingHour, String closingHour, ArrayList<Review> reviews) {
        this.id = id;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.reviews = reviews;
        this.isTrending = false;
        this.name = name;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        
        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        
        return totalRating / reviews.size();
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

    public boolean isTrending() {
        return isTrending;
    }

    public String getName(){
        return name;
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

    public void setTrending(boolean trending) {
        this.isTrending = trending;
    }

    public void setName(String name){
        this.name = name;
    }
}

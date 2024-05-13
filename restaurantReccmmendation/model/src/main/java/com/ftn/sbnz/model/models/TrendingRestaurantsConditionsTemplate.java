package com.ftn.sbnz.model.models;

public class TrendingRestaurantsConditionsTemplate {

    private int minReviews;
    private double minRating;
    private CuisineType cuisineType;

    public TrendingRestaurantsConditionsTemplate(int minReviews, double minRating, CuisineType cuisineType) {
        this.minReviews = minReviews;
        this.minRating = minRating;
        this.cuisineType = cuisineType;
    }

    public int getMinReviews() {
        return minReviews;
    }

    public void setMinReviews(int minReviews) {
        this.minReviews = minReviews;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }
}
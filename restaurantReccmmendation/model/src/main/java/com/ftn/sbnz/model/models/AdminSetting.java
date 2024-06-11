package com.ftn.sbnz.model.models;

public class AdminSetting {
    private int minReviewsInPastMonth;
    private double minRestaurantRating;
    private CuisineType desiredCuisineType;

    public AdminSetting () {
        
    }

    public int getMinReviewsInPastMonth() {
        return minReviewsInPastMonth;
    }

    public void setMinReviewsInPastMonth(int minReviewsInPastMonth) {
        this.minReviewsInPastMonth = minReviewsInPastMonth;
    }

    public double getMinRestaurantRating() {
        return minRestaurantRating;
    }

    public void setMinRestaurantRating(double minRestaurantRating) {
        this.minRestaurantRating = minRestaurantRating;
    }

    public CuisineType getDesiredCuisineType() {
        return desiredCuisineType;
    }

    public void setDesiredCuisineType(CuisineType desiredCuisineType) {
        this.desiredCuisineType = desiredCuisineType;
    }
}

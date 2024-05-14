package com.ftn.sbnz.model.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private CuisineType cuisineType;
    @Column
    private String location;
    @Column
    private double price;
    @Column
    private String openingHour;
    @Column
    private String closingHour;
    @Column
    private boolean isVegetarianFriendly;
    @Column
    private boolean isSmokerFriendly;
    @OneToMany
    private List<Review> reviews;

    public Restaurant(long id, CuisineType cuisineType, String location, double price, String openingHour, String closingHour, boolean isVegetarianFriendly, boolean isSmokerFriendly) {
        this.id = id;
        this.cuisineType = cuisineType;
        this.location = location;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.reviews = new ArrayList<>();
        this.isSmokerFriendly = isSmokerFriendly;
        this.isVegetarianFriendly = isVegetarianFriendly;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public boolean isSmokerFriendly() {
        return isSmokerFriendly;
    }

    public boolean isVegetarianFriendly() {
        return isVegetarianFriendly;
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

    public void setSmokerFriendly(boolean isSmokerFriendly) {
        this.isSmokerFriendly = isSmokerFriendly;
    }

    public void setVegetarianFriendly(boolean isVegetarianFriendly) {
        this.isVegetarianFriendly = isVegetarianFriendly;
    }
}

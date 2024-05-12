package com.ftn.sbnz.model.models;

public class Review {

    private long id;
    private User user;
    private Restaurant restaurant;
    private int rating;

    public Review(long id, User user, Restaurant restaurant, int rating) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
    }

}
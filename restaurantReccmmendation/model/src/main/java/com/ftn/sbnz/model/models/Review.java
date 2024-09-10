package com.ftn.sbnz.model.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Restaurant restaurant;
    @Column
    private int rating;
    //@Column(name = "created_at", nullable = false)
    //private LocalDateTime createdAt;

    public Review(long id, User user, Restaurant restaurant, int rating) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        //this.createdAt = LocalDateTime.now();
    }

    public Review(){
        //this.createdAt = LocalDateTime.now();
    }

    // Getters
    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getRating() {
        return rating;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

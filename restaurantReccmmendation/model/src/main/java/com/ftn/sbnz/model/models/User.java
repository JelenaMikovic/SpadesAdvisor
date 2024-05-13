package com.ftn.sbnz.model.models;

import java.util.ArrayList;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean isAdmin;
    private ArrayList<Restaurant> favoriteRestaurants;
    private ArrayList<Restaurant> recommendedRestaurants;

    public User(long id, String firstName, String lastName, String phoneNumber, String email, String password, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.favoriteRestaurants = new ArrayList<>();
        this.recommendedRestaurants = new ArrayList<>();
    }

    

}
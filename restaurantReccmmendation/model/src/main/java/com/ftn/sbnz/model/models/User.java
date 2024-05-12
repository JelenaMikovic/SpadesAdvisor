package com.ftn.sbnz.model.models;

import java.util.ArrayList;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private ArrayList<Restaurant> favoriteRestaurants;
    private boolean isAdmin;

    public User(long id, String firstName, String lastName, String phoneNumber, String email, String password, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.favoriteRestaurants = new ArrayList<>();
        this.isAdmin = isAdmin;
    }


}
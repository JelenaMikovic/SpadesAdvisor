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

    public void addFavoriteRestaurant(Restaurant restaurant) {
        favoriteRestaurants.add(restaurant);
    }

    public void removeFavoriteRestaurant(Restaurant restaurant) {
        favoriteRestaurants.remove(restaurant);
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public ArrayList<Restaurant> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public ArrayList<Restaurant> getRecommendedRestaurants() {
        return recommendedRestaurants;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setFavoriteRestaurants(ArrayList<Restaurant> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }

    public void setRecommendedRestaurants(ArrayList<Restaurant> recommendedRestaurants) {
        this.recommendedRestaurants = recommendedRestaurants;
    }

}

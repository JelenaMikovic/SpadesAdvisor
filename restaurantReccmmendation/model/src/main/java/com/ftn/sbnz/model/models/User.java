package com.ftn.sbnz.model.models;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private boolean isAdmin;
    @ManyToMany
    private List<Restaurant> favoriteRestaurants;
    @ElementCollection
    @CollectionTable(name = "user_preferred_cuisines", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "cuisine")
    @Enumerated(EnumType.STRING)
    private List<CuisineType> preferredCuisines;
    @ManyToMany
    private List<Restaurant> positivelyRatedRestaurants;
    @ManyToMany
    private List<Restaurant> visitedRestaurants;
    @ElementCollection
    @CollectionTable(name = "user_preferred_locations", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "preferred_location")
    private List<String> preferredLocations;
    @ManyToMany
    private List<Restaurant> topPicks;


    public User(long id, String firstName, String lastName, String email, String password, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.favoriteRestaurants = new ArrayList<>();
        this.preferredCuisines = new ArrayList<>();
        this.positivelyRatedRestaurants = new ArrayList<>();
        this.visitedRestaurants = new ArrayList<>();
        this.preferredLocations = new ArrayList<>();
        this.topPicks = new ArrayList<>();
    }

    public User() {
        this.favoriteRestaurants = new ArrayList<>();
        this.preferredCuisines = new ArrayList<>();
        this.positivelyRatedRestaurants = new ArrayList<>();
        this.visitedRestaurants = new ArrayList<>();
        this.preferredLocations = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public List<Restaurant> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public List<Restaurant> getPositivelyRatedRestaurants(){
        return positivelyRatedRestaurants;
    }

    public List<CuisineType> getPreferredCuisines(){
        return preferredCuisines;
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

    public void setPositivelyRatedRestaurants(List<Restaurant> positivelyRatedRestaurants){
        this.positivelyRatedRestaurants = positivelyRatedRestaurants;
    }

    public void setPreferredCuisines(List<CuisineType> preferredCuisines){
        this.preferredCuisines = preferredCuisines;
    }

    public List<Restaurant> getVisitedRestaurants() {
        return visitedRestaurants;
    }

    public void setVisitedRestaurants(List<Restaurant> visitedRestaurants) {
        this.visitedRestaurants = visitedRestaurants;
    }

    public List<String> getPreferredLocations() {
        return preferredLocations;
    }

    public void setPreferredLocations(List<String> preferredLocations) {
        this.preferredLocations = preferredLocations;
    }

    public List<Restaurant> getTopPicks() {
        return topPicks;
    }

    public void setTopPicks(List<Restaurant> topPicks) {
        this.topPicks = topPicks;
    }
}

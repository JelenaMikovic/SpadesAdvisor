package com.ftn.sbnz.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.models.CuisineType;
import com.ftn.sbnz.model.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT r FROM Restaurant r " +
           "WHERE (:minPrice IS NULL OR r.price >= :minPrice) " +
           "AND (:maxPrice IS NULL OR r.price <= :maxPrice) " +
           "AND (:isVegetarianFriendly IS NULL OR r.isVegetarianFriendly = :isVegetarianFriendly) " +
           "AND (:isSmokerFriendly IS NULL OR r.isSmokerFriendly = :isSmokerFriendly) " +
           "AND (:location IS NULL OR r.location = :location) " +
           "AND (:cuisineType IS NULL OR r.cuisineType = :cuisineType) " +
           "AND (:minAvgRating IS NULL OR (SELECT AVG(re.rating) FROM r.reviews re) >= :minAvgRating) " +
           "GROUP BY r.id " +
           "ORDER BY AVG((SELECT re.rating FROM r.reviews re)) DESC")
    List<Restaurant> findFilteredRestaurants(
            Double minPrice,
            Double maxPrice,
            Boolean isVegetarianFriendly,
            Boolean isSmokerFriendly,
            String location,
            CuisineType cuisineType,
            Double minAvgRating
    );

    List<Restaurant> findByNameContainingIgnoreCase(String name);
    
}
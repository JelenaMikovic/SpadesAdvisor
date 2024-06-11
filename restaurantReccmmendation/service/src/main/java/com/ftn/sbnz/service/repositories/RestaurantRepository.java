package com.ftn.sbnz.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.models.CuisineType;
import com.ftn.sbnz.model.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT r FROM Restaurant r " +
       "LEFT JOIN r.reviews re " +
       "WHERE (:minPrice IS NULL OR r.price >= :minPrice) " +
       "AND (:maxPrice IS NULL OR r.price <= :maxPrice) " +
       "AND (:isVegetarianFriendly IS NULL OR r.isVegetarianFriendly = :isVegetarianFriendly) " +
       "AND (:isSmokerFriendly IS NULL OR r.isSmokerFriendly = :isSmokerFriendly) " +
       "AND (:location IS NULL OR r.location = :location) " +
       "AND (:cuisineType IS NULL OR r.cuisineType = :cuisineType) " +
       "GROUP BY r.id " +
       "HAVING (:minAvgRating IS NULL OR AVG(re.rating) >= :minAvgRating) " +
       "ORDER BY AVG(re.rating) DESC")
List<Restaurant> findFilteredRestaurants(
        @Param("minPrice") Double minPrice,
        @Param("maxPrice") Double maxPrice,
        @Param("isVegetarianFriendly") Boolean isVegetarianFriendly,
        @Param("isSmokerFriendly") Boolean isSmokerFriendly,
        @Param("location") String location,
        @Param("cuisineType") CuisineType cuisineType,
        @Param("minAvgRating") Double minAvgRating);

    List<Restaurant> findByNameContainingIgnoreCase(String name);
    
}
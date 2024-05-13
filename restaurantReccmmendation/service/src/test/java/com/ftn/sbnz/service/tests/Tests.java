package com.ftn.sbnz.service.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
// import org.kie.api.KieServices;
// import org.kie.api.runtime.KieContainer;
// import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.CuisineType;
import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.model.models.TrendingRestaurantsConditionsTemplate;
import com.ftn.sbnz.service.RestaurantRecommendationService;



public class Tests {

    @Test
    public void test() {
        // KieServices ks = KieServices.Factory.get();
        // KieContainer kContainer = ks.getKieClasspathContainer(); 
        // KieSession ksession = kContainer.newKieSession("cepKsession");
      
    }

    @Test
    public void testTrendingRestaurants() {

        TrendingRestaurantsConditionsTemplate template = new TrendingRestaurantsConditionsTemplate(10, 4.5, CuisineType.ITALIAN);
        
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "Restaurant A", CuisineType.ITALIAN, "Maksima Gorkog 1, Novi Sad", 15.0, "10:00", "21:00", generateReviews(15, 4.6)));
        restaurants.add(new Restaurant(2L, "Restaurant B", CuisineType.MEXICAN, "Maksima Gorkog 2, Novi Sad", 20.0, "10:00", "21:00", generateReviews(20, 4.7)));
        restaurants.add(new Restaurant(3L, "Restaurant C", CuisineType.ITALIAN, "Maksima Gorkog 3, Novi Sad", 12.0, "10:00", "21:00", generateReviews(12, 4.4)));

            List<Restaurant> trendingRestaurants = RestaurantRecommendationService.findTrendingRestaurants(restaurants, template);

            for (Restaurant restaurant : trendingRestaurants) {
                assertTrue(restaurant.isTrending());
            }
    }

    private ArrayList<Review> generateReviews(int count, double rating) {
        ArrayList<Review> reviews = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            reviews.add(new Review(rating));
        }
        return reviews;
    }
}

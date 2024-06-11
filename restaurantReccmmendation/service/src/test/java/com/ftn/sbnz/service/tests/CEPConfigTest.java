package com.ftn.sbnz.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.drools.compiler.kie.builder.impl.KieFileSystemImpl;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.AdminSetting;
import com.ftn.sbnz.model.models.CuisineType;
import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.model.models.User;



public class CEPConfigTest {

    @Test
    public void test() {
        // Load KieServices
            KieServices kieServices = KieServices.Factory.get();

            // Load KieContainer from classpath
            KieContainer kieContainer = kieServices.getKieClasspathContainer();

            // Create a new KieSession
            KieSession kieSession = kieContainer.newKieSession("forwardKsession");

            // Create some Restaurant objects
            Restaurant restaurant1 = new Restaurant();
            restaurant1.setName("Italian Bistro");
            restaurant1.setCuisineType(CuisineType.ITALIAN);

            Restaurant restaurant2 = new Restaurant();
            restaurant2.setName("Sushi Place");
            restaurant2.setCuisineType(CuisineType.ITALIAN);

            // Add restaurants to a list
            List<Restaurant> allRestaurants = new ArrayList<>();
            allRestaurants.add(restaurant1);
            allRestaurants.add(restaurant2);

            // Create a list for recommended restaurants
            List<Restaurant> recommendedRestaurants = new ArrayList<>();

            // Set the global list of recommended restaurants
            kieSession.setGlobal("recommendedRestaurantsRating", recommendedRestaurants);

            // Create a User object
            User user = new User();
            user.setFirstName("John");

            // Create a Review object
            Review review = new Review();
            review.setUser(user);
            review.setRestaurant(restaurant1);
            review.setRating(5);

            // Insert the objects into the session
            kieSession.insert(user);
            kieSession.insert(restaurant1);
            kieSession.insert(restaurant2);
            kieSession.insert(review);

            // Fire all rules
            kieSession.fireAllRules();

            // Dispose the session
            kieSession.dispose();

            // Print recommended restaurants
            System.out.println("Recommended Restaurants:");
            for (Restaurant restaurant : recommendedRestaurants) {
                System.out.println(restaurant.getName());
            }
    }

    @Test
    public void test2() {
        // Load KieServices
        KieServices kieServices = KieServices.Factory.get();

        // Load KieContainer from classpath
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // Create a new KieSession
        KieSession kSession = kieContainer.newKieSession("forwardKsession");

        List<Restaurant> recommendedRestaurants = new ArrayList<>();
        Map<String, Integer> locationVisitCounts = new HashMap<>();

        kSession.setGlobal("recommendedRestaurantsLocation", recommendedRestaurants);
        kSession.setGlobal("locationVisitCounts", locationVisitCounts);

        System.out.println("dsadasd");

        User user = new User();
        user.setFirstName("John");
        kSession.insert(user);

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setLocation("123 Main St, Downtown, Springfield");

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Sushi Place");
        restaurant2.setLocation("456 Elm St, Downtown, Springfield");

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setName("Sushi Place2");
        restaurant3.setLocation("456 Elm St, Downtown, Springfield");

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setName("Sushi Place3");
        restaurant4.setLocation("456 Elm St, Downtown, Springfield");

        Review review1 = new Review();
        review1.setUser(user);
        review1.setRestaurant(restaurant1);
        review1.setRating(3);

        Review review2 = new Review();
        review2.setUser(user);
        review2.setRestaurant(restaurant2);
        review2.setRating(4);

        Review review3 = new Review();
        review3.setUser(user);
        review3.setRestaurant(restaurant3);
        review3.setRating(3);

        kSession.insert(restaurant1);
        kSession.insert(restaurant2);
        kSession.insert(restaurant3);
        kSession.insert(restaurant4);

        kSession.insert(review1);
        kSession.insert(review2);
        kSession.insert(review3);

        kSession.fireAllRules();

        assertTrue(user.getVisitedRestaurants().contains(restaurant1));
        assertTrue(user.getVisitedRestaurants().contains(restaurant2));
        assertTrue(user.getPreferredLocations().contains("Downtown"));
        assertTrue(recommendedRestaurants.contains(restaurant2));
    }

    @Test
    public void test3() {
        // Load KieServices
        KieServices kieServices = KieServices.Factory.get();

        // Load KieContainer from classpath
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // Create a new KieSession
        KieSession kSession = kieContainer.newKieSession("cepKsession");
        
        List<Restaurant> recommendations = new ArrayList<>();
        List<Restaurant> allRestaurants = new ArrayList<>();


        kSession.setGlobal("recommendationList", recommendations);
        
        SessionPseudoClock clock = kSession.getSessionClock();

        // Create test data
        User user = new User();
        user.setFirstName("John");

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setCuisineType(CuisineType.ITALIAN);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Sushi Place");
        restaurant2.setCuisineType(CuisineType.ITALIAN);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setName("Sushi sasa");
        restaurant3.setCuisineType(CuisineType.ITALIAN);

        // Add restaurants to global list
        kSession.insert(user);
        allRestaurants.add(restaurant1);
        allRestaurants.add(restaurant2);
        allRestaurants.add(restaurant3);

        kSession.setGlobal("allRestaurants", allRestaurants);


        // Insert reviews into the session
        Review review1 = new Review();
        review1.setUser(user);
        review1.setRestaurant(restaurant1);
        review1.setRating(3);

        Review review2 = new Review();
        review2.setUser(user);
        review2.setRestaurant(restaurant2);
        review2.setRating(4);

        kSession.insert(review1);
                // Advance the clock by 1 day (ensure within 7 days window)
        clock.advanceTime(1, TimeUnit.DAYS);
        kSession.insert(review2);

        // Fire all rules
        kSession.fireAllRules();

        // Check if the recommendation list contains the expected restaurant
        assertTrue(recommendations.contains(restaurant3));
        assertEquals(3, recommendations.size());

        // Output the recommendations for visual inspection
        recommendations.forEach(restaurant ->
            System.out.println("Recommended Restaurant: " + restaurant.getName())
        );
    }

}

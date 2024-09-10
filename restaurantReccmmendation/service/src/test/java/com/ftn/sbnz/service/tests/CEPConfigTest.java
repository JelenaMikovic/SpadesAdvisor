package com.ftn.sbnz.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;

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


    //CEP 2 TESTOVI

    @Test
    public void testOnlyPositiveReviewedRestaurantsWithinPriceRange() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");

        List<Restaurant> positiveReviewRecommendations = new ArrayList<>();
        kieSession.setGlobal("positiveReviewRecommendations", positiveReviewRecommendations);

        List<Restaurant> allRestaurants = new ArrayList<>();
        kieSession.setGlobal("allRestaurants", allRestaurants);

        User user = new User();
        user.setFirstName("John");

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setPrice(500);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Sushi Place");
        restaurant2.setPrice(450);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setName("Burger Joint");
        restaurant3.setPrice(700);


        allRestaurants.add(restaurant1);
        allRestaurants.add(restaurant2);
        allRestaurants.add(restaurant3);

        Review review1 = new Review();
        review1.setRestaurant(restaurant1);
        review1.setUser(user);
        review1.setRating(5);

        Review review2 = new Review();
        review2.setRestaurant(restaurant2);
        review2.setUser(user);
        review2.setRating(4);

        Review review3 = new Review();
        review3.setRestaurant(restaurant3);
        review3.setUser(user);
        review3.setRating(4);

        kieSession.insert(user);
        kieSession.insert(review1);
        kieSession.insert(review2);
        kieSession.insert(review3);

        kieSession.fireAllRules();

        assertTrue(positiveReviewRecommendations.contains(restaurant1));
        assertTrue(positiveReviewRecommendations.contains(restaurant2));
        assertFalse(positiveReviewRecommendations.contains(restaurant3)); // Should not be included
        assertEquals(2, positiveReviewRecommendations.size());
    }

    @Test
    public void testPositiveReviewOutsidePriceRangeNotIncluded() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");
    
        List<Restaurant> positiveReviewRecommendations = new ArrayList<>();
        kieSession.setGlobal("positiveReviewRecommendations", positiveReviewRecommendations);
    
        List<Restaurant> allRestaurants = new ArrayList<>();
        kieSession.setGlobal("allRestaurants", allRestaurants);
    
        User user = new User();
        user.setFirstName("John");
    
        // Kreiraj restoran sa cenom van opsega
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Expensive Place");
        restaurant1.setPrice(1200); // outside price range
    
        allRestaurants.add(restaurant1);
    
        // Pozitivna recenzija za restoran van opsega
        Review review1 = new Review();
        review1.setUser(user);
        review1.setRestaurant(restaurant1);
        review1.setRating(5); // Positive review
    
        kieSession.insert(user);
        kieSession.insert(review1);
    
        kieSession.fireAllRules();
    
        assertFalse(positiveReviewRecommendations.contains(restaurant1)); // Should not be included
        assertEquals(0, positiveReviewRecommendations.size());
    }
    
    @Test
    public void testNoPositiveReviewsNoRecommendations() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");
    
        List<Restaurant> positiveReviewRecommendations = new ArrayList<>();
        kieSession.setGlobal("positiveReviewRecommendations", positiveReviewRecommendations);
    
        List<Restaurant> allRestaurants = new ArrayList<>();
        kieSession.setGlobal("allRestaurants", allRestaurants);
    
        User user = new User();
        user.setFirstName("John");
    
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setPrice(500);
    
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Sushi Place");
        restaurant2.setPrice(450);
    
        allRestaurants.add(restaurant1);
        allRestaurants.add(restaurant2);
    
        // Nema recenzija
    
        kieSession.insert(user);
    
        kieSession.fireAllRules();
    
        assertTrue(positiveReviewRecommendations.isEmpty()); // No recommendations since no positive reviews
    }
    
    @Test
    public void testNegativeReviewedRestaurantsNotIncluded() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");
    
        List<Restaurant> positiveReviewRecommendations = new ArrayList<>();
        kieSession.setGlobal("positiveReviewRecommendations", positiveReviewRecommendations);
    
        List<Restaurant> allRestaurants = new ArrayList<>();
        kieSession.setGlobal("allRestaurants", allRestaurants);
    
        User user = new User();
        user.setFirstName("John");
    
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setPrice(500);
    
        allRestaurants.add(restaurant1);
    
        // Negativna recenzija
        Review review1 = new Review();
        review1.setUser(user);
        review1.setRestaurant(restaurant1);
        review1.setRating(2); // Negative review
    
        kieSession.insert(user);
        kieSession.insert(review1);
    
        kieSession.fireAllRules();
    
        assertFalse(positiveReviewRecommendations.contains(restaurant1)); // Should not be included
        assertEquals(0, positiveReviewRecommendations.size());
    }

    @Test
    public void testMixedReviewScenariosWithPseudoClock() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");
    
        // Koristi pseudo-clock za manipulaciju vremenom
        SessionPseudoClock clock = kieSession.getSessionClock();
        
        List<Restaurant> positiveReviewRecommendations = new ArrayList<>();
        kieSession.setGlobal("positiveReviewRecommendations", positiveReviewRecommendations);
        
        List<Restaurant> allRestaurants = new ArrayList<>();
        kieSession.setGlobal("allRestaurants", allRestaurants);
        
        User user = new User();
        user.setFirstName("John");
    
        // Kreiranje restorana
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Italian Bistro");
        restaurant1.setPrice(500);
    
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Sushi Place");
        restaurant2.setPrice(450);
    
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setName("Burger Joint");
        restaurant3.setPrice(700);
    
        Restaurant restaurant4 = new Restaurant();
        restaurant4.setName("Old Diner");
        restaurant4.setPrice(600);
    
        // Dodavanje svih restorana u listu
        allRestaurants.add(restaurant1);
        allRestaurants.add(restaurant2);
        allRestaurants.add(restaurant3);
        allRestaurants.add(restaurant4);
    
        // Kreiranje recenzija
        Review review1 = new Review();
        review1.setUser(user);
        review1.setRestaurant(restaurant1);
        review1.setRating(5); // Pozitivna recenzija
    
        Review review2 = new Review();
        review2.setUser(user);
        review2.setRestaurant(restaurant2);
        review2.setRating(4); // Pozitivna recenzija
    
        Review review3 = new Review();
        review3.setUser(user);
        review3.setRestaurant(restaurant3);
        review3.setRating(2); // Negativna recenzija
    
        Review review4 = new Review();
        review4.setUser(user);
        review4.setRestaurant(restaurant4);
        review4.setRating(4); // Pozitivna recenzija, ali postavljena u prošlost (48 sati kasnije)
    
        // Ubacivanje recenzije i pomeranje sata unapred kako bi se simulirala proslost
        kieSession.insert(review4);

        clock.advanceTime(49, TimeUnit.HOURS);

        kieSession.insert(review1);
        kieSession.insert(review2);
        kieSession.insert(review3);
    
        // Pomeri vreme unapred za 49 sati
        // Pokretanje pravila nakon prolaska vremena

        kieSession.fireAllRules();
        
        
        // Provera rezultata
        assertTrue(positiveReviewRecommendations.contains(restaurant1)); // Treba biti uključen
        assertTrue(positiveReviewRecommendations.contains(restaurant2)); // Treba biti uključen
        assertFalse(positiveReviewRecommendations.contains(restaurant3)); // Negativna recenzija, ne treba biti uključen
        assertFalse(positiveReviewRecommendations.contains(restaurant4)); // Starija od 48 sati, ne treba biti uključen
    }

}

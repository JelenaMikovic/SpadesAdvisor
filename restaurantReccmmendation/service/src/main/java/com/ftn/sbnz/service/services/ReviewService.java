package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.ReviewDTO;
import com.ftn.sbnz.service.repositories.RestaurantRepository;
import com.ftn.sbnz.service.repositories.ReviewRepository;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.interfaces.IReviewService;

@Service
public class ReviewService implements IReviewService{

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;
    private final KieContainer kieContainer;
    private final KieSession kieSession;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository, KieContainer kieContainer) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.kieContainer = kieContainer;
        this.kieSession =this.kieContainer.newKieSession("cepKsession");
    }

    @Override
    public Boolean addReview(ReviewDTO reviewDTO, Long userId) {
        List<Restaurant> recommendationList = new ArrayList<>();
        kieSession.setGlobal("recommendationList", recommendationList);
        kieSession.setGlobal("allRestaurants", this.restaurantRepository.findAll());
                // Pronalaženje restorana na osnovu ID-a iz reviewDTO
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(reviewDTO.getRestaurantId());
        if (restaurantOptional.isEmpty()) {
            throw new IllegalArgumentException("Restoran sa datim ID-em nije pronađen.");
        }
        Restaurant restaurant = restaurantOptional.get();

        // Pronalaženje korisnika na osnovu ID-a
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Korisnik sa datim ID-em nije pronađen.");
        }
        User user = userOptional.get();
        kieSession.insert(user);
        // Kreiranje Review objekta
        Review review = new Review();
        review.setRestaurant(restaurant);
        review.setUser(user);
        //review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        // Dodatne postavke ako postoje

        // Čuvanje recenzije u bazi podataka
        reviewRepository.save(review);

        kieSession.insert(review);
        kieSession.fireAllRules();

        System.out.println(recommendationList.size());
        user.setTopPicks(recommendationList);
        userRepository.save(user);

        return true;
    }
}

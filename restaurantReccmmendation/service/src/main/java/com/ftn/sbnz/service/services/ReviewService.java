package com.ftn.sbnz.service.services;

import java.util.Optional;

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

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Boolean addReview(ReviewDTO reviewDTO, Long userId) {
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

        // Kreiranje Review objekta
        Review review = new Review();
        review.setRestaurant(restaurant);
        review.setUser(user);
        //review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        // Dodatne postavke ako postoje

        // Čuvanje recenzije u bazi podataka
        reviewRepository.save(review);

        return true;
    }
}

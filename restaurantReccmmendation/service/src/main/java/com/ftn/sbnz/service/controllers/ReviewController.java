package com.ftn.sbnz.service.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ftn.sbnz.service.dtos.ReviewDTO;
import com.ftn.sbnz.service.services.interfaces.IReviewService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/reviews")
public class ReviewController {

	private IReviewService reviewService;

	@Autowired
	public ReviewController(IReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping("/newReview")
	public Boolean addReview(@RequestBody ReviewDTO reviewDTO, @SessionAttribute("userId") Long userId){
		// TODO pozovi servis za dodavanje recenzije
		return reviewService.addReview(reviewDTO, userId);
	}
}
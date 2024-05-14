package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
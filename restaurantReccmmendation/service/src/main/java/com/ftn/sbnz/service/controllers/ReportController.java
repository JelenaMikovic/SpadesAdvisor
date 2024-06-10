package com.ftn.sbnz.service.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.service.services.interfaces.IReportService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/report")
public class ReportController {

	private IReportService reportService;

	@Autowired
	public ReportController(IReportService reportService) {
		this.reportService = reportService;
	}

    @GetMapping("/favorite-restaurants")
    public ResponseEntity<HashMap<String, Integer>> usersFavouriteRestaurants(HttpSession session){
        return ResponseEntity.ok(reportService.usersFavouriteRestaurants((Long) session.getAttribute("userId")));
    }

    @GetMapping("/favorite-cuisine")
    public ResponseEntity<HashMap<String, Integer>> usersMostVisitedCuisine(HttpSession session){
        return ResponseEntity.ok(reportService.usersMostVisitedCuisine((Long) session.getAttribute("userId")));
    }
	
}
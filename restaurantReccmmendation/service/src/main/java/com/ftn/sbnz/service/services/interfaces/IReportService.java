package com.ftn.sbnz.service.services.interfaces;

import java.util.HashMap;

public interface IReportService {

    HashMap<String, Integer> usersFavouriteRestaurants(Long userId);
    HashMap<String, Integer> usersMostVisitedCuisine(Long userId);
    
}

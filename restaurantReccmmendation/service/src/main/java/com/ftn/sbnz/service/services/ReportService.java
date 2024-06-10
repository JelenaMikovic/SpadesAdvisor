package com.ftn.sbnz.service.services;

import java.util.HashMap;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.service.repositories.ReviewRepository;
import com.ftn.sbnz.service.services.interfaces.IReportService;

@Service
public class ReportService implements IReportService {

    @Autowired
    private KieContainer kieContainer;
    private ReviewRepository reviewRepository;

    @Autowired
    public ReportService(KieContainer kieContainer, ReviewRepository reviewRepository){
        this.kieContainer = kieContainer;
        this.reviewRepository = reviewRepository;
    }


    @Override
    public HashMap<String, Integer> usersFavouriteRestaurants(Long userId) {
        KieSession kieSession = kieContainer.newKieSession("queryKsession");
        for(Review r: reviewRepository.findAll()) {
            kieSession.insert(r);
            kieSession.insert(r.getUser());
            kieSession.insert(r.getRestaurant());
        }
        QueryResults results = kieSession.getQueryResults("usersFavouriteRestaurants", userId);
        System.out.println(results.size());
        HashMap<String, Integer> map = new HashMap<>();
        for (QueryResultsRow row : results) {
            HashMap<String, Integer> resultMap = (HashMap<String, Integer>) row.get("$map");
            for (String key : resultMap.keySet()) {
                map.merge(key, resultMap.get(key), Integer::sum);
            }
        }
        return map;
    }
    
    @Override
    public HashMap<String, Integer> usersMostVisitedCuisine(Long userId) {
        KieSession kieSession = kieContainer.newKieSession("queryKsession");
        QueryResults results = kieSession.getQueryResults("mostVisitedCuisineTypes", userId);
        HashMap<String, Integer> map = new HashMap<>();
        for (QueryResultsRow row : results) {
            HashMap<String, Integer> cuisineTypeMap = (HashMap<String, Integer>) row.get("$cuisineMap");
            map.putAll(cuisineTypeMap);
        }
        return map;
    }
    
}

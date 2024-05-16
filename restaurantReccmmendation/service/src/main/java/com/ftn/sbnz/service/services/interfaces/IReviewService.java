package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.service.dtos.ReviewDTO;

public interface IReviewService {

    Boolean addReview(ReviewDTO reviewDTO, Long userId);
    
}

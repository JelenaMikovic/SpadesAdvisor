package com.ftn.sbnz.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
   
}
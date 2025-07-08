package com.example.ratingmanagementsystem.service;

import com.example.ratingmanagementsystem.model.Rating;
import com.example.ratingmanagementsystem.model.User;
import com.example.ratingmanagementsystem.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByUser(User user) {
        return ratingRepository.findByUser(user);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}

package com.example.ratingmanagementsystem.repository;

import com.example.ratingmanagementsystem.model.Rating;
import com.example.ratingmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUser(User user);
}

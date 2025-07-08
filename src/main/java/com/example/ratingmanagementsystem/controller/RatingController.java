
package com.example.ratingmanagementsystem.controller;

import com.example.ratingmanagementsystem.model.Rating;
import com.example.ratingmanagementsystem.model.User;
import com.example.ratingmanagementsystem.service.RatingService;
import com.example.ratingmanagementsystem.service.UserService;
import com.example.ratingmanagementsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping
    public String addRating(@RequestHeader("Authorization") String token, @RequestBody Rating rating) {
        String email = jwtUtil.extractUsername(token.substring(7));
        User user = userService.findByEmail(email).orElse(null);

        if (user == null) {
            return "Invalid user";
        }

        rating.setUser(user);
        ratingService.saveRating(rating);
        return "Rating submitted successfully";
    }

    @GetMapping("/my")
    public List<Rating> getMyRatings(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        User user = userService.findByEmail(email).orElse(null);

        if (user == null) {
            return null;
        }

        return ratingService.getRatingsByUser(user);
    }
}

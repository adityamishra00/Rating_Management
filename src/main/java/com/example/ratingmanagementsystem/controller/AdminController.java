//
//package com.example.ratingmanagementsystem.controller;
//
//import com.example.ratingmanagementsystem.model.Rating;
//import com.example.ratingmanagementsystem.service.RatingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private RatingService ratingService;
//
//    // Sabki Ratings dekhne ke liye
//    @GetMapping("/ratings")
//    public List<Rating> getAllRatings() {
//        return ratingService.getAllRatings();
//    }
//
//    // Filter laga ke dekhne ke liye
//    @GetMapping("/ratings/filter")
//    public List<Rating> filterRatings(
//            @RequestParam(required = false) Integer ambiance,
//            @RequestParam(required = false) Integer food) {
//
//        List<Rating> allRatings = ratingService.getAllRatings();
//
//        return allRatings.stream()
//                .filter(r -> (ambiance == null || r.getAmbiance() == ambiance))
//                .filter(r -> (food == null || r.getFood() == food))
//                .toList();
//    }
//
//    // Average Report dekhne ke liye
//    @GetMapping("/ratings/average")
//    public String getAverageReport() {
//        List<Rating> allRatings = ratingService.getAllRatings();
//
//        if (allRatings.isEmpty()) {
//            return "No ratings available to calculate average.";
//        }
//
//        double avgAmbiance = allRatings.stream().mapToInt(Rating::getAmbiance).average().orElse(0);
//        double avgFood = allRatings.stream().mapToInt(Rating::getFood).average().orElse(0);
//        double avgService = allRatings.stream().mapToInt(Rating::getService).average().orElse(0);
//        double avgCleanliness = allRatings.stream().mapToInt(Rating::getCleanliness).average().orElse(0);
//        double avgDrinks = allRatings.stream().mapToInt(Rating::getDrinks).average().orElse(0);
//
//        return "Average Ambiance: " + avgAmbiance +
//                ", Food: " + avgFood +
//                ", Service: " + avgService +
//                ", Cleanliness: " + avgCleanliness +
//                ", Drinks: " + avgDrinks;
//    }
//}
package com.example.ratingmanagementsystem.controller;

import com.example.ratingmanagementsystem.model.Rating;
import com.example.ratingmanagementsystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RatingService ratingService;

    // Sabki Ratings dekhne ke liye
    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    // Complete Filter laga ke dekhne ke liye
    @GetMapping("/ratings/filter")
    public List<Rating> filterRatings(
            @RequestParam(required = false) Integer ambiance,
            @RequestParam(required = false) Integer food,
            @RequestParam(required = false) Integer service,
            @RequestParam(required = false) Integer cleanliness,
            @RequestParam(required = false) Integer drinks
    ) {

        List<Rating> allRatings = ratingService.getAllRatings();

        return allRatings.stream()
                .filter(r -> (ambiance == null || r.getAmbiance() == ambiance))
                .filter(r -> (food == null || r.getFood() == food))
                .filter(r -> (service == null || r.getService() == service))
                .filter(r -> (cleanliness == null || r.getCleanliness() == cleanliness))
                .filter(r -> (drinks == null || r.getDrinks() == drinks))
                .toList();
    }

    // Average Report dekhne ke liye
    @GetMapping("/ratings/average")
    public String getAverageReport() {
        List<Rating> allRatings = ratingService.getAllRatings();

        if (allRatings.isEmpty()) {
            return "No ratings available to calculate average.";
        }

        double avgAmbiance = allRatings.stream().mapToInt(Rating::getAmbiance).average().orElse(0);
        double avgFood = allRatings.stream().mapToInt(Rating::getFood).average().orElse(0);
        double avgService = allRatings.stream().mapToInt(Rating::getService).average().orElse(0);
        double avgCleanliness = allRatings.stream().mapToInt(Rating::getCleanliness).average().orElse(0);
        double avgDrinks = allRatings.stream().mapToInt(Rating::getDrinks).average().orElse(0);

        return "Average Ambiance: " + avgAmbiance +
                ", Food: " + avgFood +
                ", Service: " + avgService +
                ", Cleanliness: " + avgCleanliness +
                ", Drinks: " + avgDrinks;
    }
}

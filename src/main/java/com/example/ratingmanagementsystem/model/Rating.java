package com.example.ratingmanagementsystem.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ambiance;
    private int food;
    private int service;
    private int cleanliness;
    private int drinks;

    @ManyToOne
    private User user;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getAmbiance() { return ambiance; }
    public void setAmbiance(int ambiance) { this.ambiance = ambiance; }

    public int getFood() { return food; }
    public void setFood(int food) { this.food = food; }

    public int getService() { return service; }
    public void setService(int service) { this.service = service; }

    public int getCleanliness() { return cleanliness; }
    public void setCleanliness(int cleanliness) { this.cleanliness = cleanliness; }

    public int getDrinks() { return drinks; }
    public void setDrinks(int drinks) { this.drinks = drinks; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

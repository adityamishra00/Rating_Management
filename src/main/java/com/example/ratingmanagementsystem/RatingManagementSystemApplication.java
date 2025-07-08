package com.example.ratingmanagementsystem;

import com.example.ratingmanagementsystem.model.User;
import com.example.ratingmanagementsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repo) {
		return args -> {
			repo.findById(1L).ifPresentOrElse(
					user -> System.out.println("Admin User already exists"),
					() -> {
						repo.save(new User(null, "Admin User", "admin@example.com", "xyz", "ADMIN"));
						System.out.println("Admin User created");
					}
			);
		};
	}

}

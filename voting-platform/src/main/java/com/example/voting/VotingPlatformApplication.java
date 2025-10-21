package com.example.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class VotingPlatformApplication {
	public static void main(String[] args) {
		// Explicitly load .env file (require setting the correct path if needed)
		Dotenv dotenv = Dotenv.configure()
				.directory("C:/Users/HP/Downloads/voting platform/voting-platform")
				.load();

		// Set these as System properties so Spring can see them
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
		System.setProperty("JWT_EXPIRATION_MS", dotenv.get("JWT_EXPIRATION_MS"));
		System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
		System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));

		SpringApplication.run(VotingPlatformApplication.class, args);
	}
}


//@SpringBootApplication
//public class VotingPlatformApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(VotingPlatformApplication.class, args);
//	}
//
//}

//import io.github.cdimascio.dotenv.Dotenv;
//
//@SpringBootApplication
//public class VotingPlatformApplication {
//	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.load();
//
//		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
//		System.setProperty("DB_URL", dotenv.get("DB_URL"));
//		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
//		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
//		System.setProperty("JWT_EXPIRATION_MS", dotenv.get("JWT_EXPIRATION_MS"));
//		System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
//		System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
//
//		SpringApplication.run(VotingPlatformApplication.class, args);
//	}
//}

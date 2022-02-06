package com.example.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApiApplication {
	private static final Logger log = LoggerFactory.getLogger(BookApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			if (repository.findAll().isEmpty()){ //insert data if no data in the database
				Book b1, b2, b3;
				b1 = new Book("Hacking with Spring Boot 2.3","Greg L. Turnquist");
				b2 = new Book("97 Things Every Java Programmer Should Know", "Kevlin Henney and Trisha Gee");
				b3 = new Book("Spring Boot: Up and Running","Greg L. Turnquist ");
				repository.save(b1);
				repository.save(b2);
				repository.save(b3);
			}

			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book b : repository.findAll()) {
				log.info(b.toString());
			}
		};
	}
}

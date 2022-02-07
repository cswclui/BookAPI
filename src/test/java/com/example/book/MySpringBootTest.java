package com.example.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MySpringBootTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnFirstBook() throws Exception {
		Book b= this.restTemplate.getForObject("http://localhost:" + port + "/books/1", Book.class);
		assertEquals("Hacking with Spring Boot 2.3", b.getTitle());
		assertEquals("Greg L. Turnquist", b.getAuthor());
	}

	@Autowired
	BookRepository repo;
	
	@Test
	public void shouldReturnAllBook()  {
		System.out.println("----shouldReturnBookListByHTTP-----");
		System.out.println(repo.findAll());
		System.out.println("---------");

		//verify that there are 3 books
		assertEquals(3, repo.findAll().size());
	}
}

package com.example.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository repo; //class under test

    @BeforeEach
    void beforeEach(){
        repo.deleteAll();
        repo.save(new Book("Book1","Author1"));
        repo.save(new Book("Book2","Author2"));
    }

    @Test
    void shouldReturnNumberOfBooks() {
        int book_count=repo.findAll().size();
        assertEquals(2,book_count);
    }

    @Test
    void shouldSaveNewBooks() {
        repo.save(new Book(6, "Book3","Author3"));
        Book b = repo.findById(6).orElse(null);
        assertEquals("Author3",b.getAuthor());
    }
}

//mvn test -Dtest=com.example.book.BookRepositoryTest
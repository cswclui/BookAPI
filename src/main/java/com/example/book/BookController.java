package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookservice;

    @GetMapping
    public List<Book> list() {
        return bookservice.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        Book b = bookservice.get(id);
        if (b!=null)
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(b);
        else
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Book not found!");
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        bookservice.create(book);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookservice.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        bookservice.delete(id);
    }
}
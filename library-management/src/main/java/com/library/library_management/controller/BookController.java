package com.library.library_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_management.model.Book;
import com.library.library_management.service.BookService;

@RestController // Tells Spring: "This is a Waiter. Serve data as JSON."
@RequestMapping("/api/books")
@CrossOrigin // The base URL for everything in this file
public class BookController {

    private final BookService bookService;

    // Inject the Chef into the Waiter's hands
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // HTTP GET Request: Read Data
    // URL: GET http://localhost:8080/api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // HTTP POST Request: Create Data
    // URL: POST http://localhost:8080/api/books
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        // @RequestBody takes the JSON sent by the frontend and magically turns it into a Java Book object!
        return bookService.addBook(book);
    }
}
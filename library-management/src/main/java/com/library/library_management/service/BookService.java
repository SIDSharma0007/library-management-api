package com.library.library_management.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.library_management.model.Book;
import com.library.library_management.repository.BookRepository;

@Service // Tells Spring: "This is a Chef. Let it handle the business rules."
public class BookService {

    // The Chef needs the Pantry Manager to get ingredients
    private final BookRepository bookRepository;

    // Constructor Injection (Industry Standard)
    // Spring Boot automatically passes the repository into this constructor when the app starts
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // --- Business Logic Methods ---

    // 1. Get all books for the user to view
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // The repository writes the SQL: SELECT * FROM book;
    }

    // 2. Add a new book (Admin action)
    public Book addBook(Book book) {
        return bookRepository.save(book); // The repository writes the SQL: INSERT INTO book...
    }

    // 3. Find a specific book by its ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
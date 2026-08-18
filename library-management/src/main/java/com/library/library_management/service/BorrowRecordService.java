package com.library.library_management.service;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.library.library_management.model.Book;
import com.library.library_management.model.BorrowRecord;
import com.library.library_management.model.User;
import com.library.library_management.repository.BookRepository;
import com.library.library_management.repository.BorrowRecordRepository;
import com.library.library_management.repository.UserRepository;
@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    BorrowRecordService(BorrowRecordRepository borrowRepository,BookRepository bookRepository,UserRepository userRepository){
        this.borrowRepository=borrowRepository;
        this.bookRepository=bookRepository;
        this.userRepository=userRepository;
    }

    public String borrowBook(Long bookId, Long userId) {
        Book book=bookRepository.findById(bookId).orElse(null);
        User user=userRepository.findById(userId).orElse(null);
        if (book==null) return "Book not found.";
        if (user==null) return "User not found";
        if ((!book.isAvailable())) return "Book is already borrowed.";
        // 3. Check if the book is null. If it is, return "Book not found."
        // 4. Check if the user is null. If it is, return "User not found."
        // 5. Check if the book is NOT available (!book.isAvailable()). Return "Book is already borrowed."
        book.setAvailable(false);
        bookRepository.save(book);
        // 6. If we get here, it's safe to borrow!
        // - Set the book's availability to false.
        // - Save the updated book back to the bookRepository.
        BorrowRecord borrowRecord= new BorrowRecord();
        borrowRecord.setBook(book);
        borrowRecord.setUser(user);
        borrowRecord.setBorrowDate(LocalDate.now());
        borrowRepository.save(borrowRecord);
        // 7. Create a new BorrowRecord object.
        // - set the Book
        // - set the User
        // - set the BorrowDate to LocalDate.now()

        // 8. Save the new BorrowRecord to the borrowRepository.
        
        return "Book borrowed successfully!";
    }
}
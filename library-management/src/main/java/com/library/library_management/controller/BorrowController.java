package com.library.library_management.controller;
import org.springframework.web.bind.annotation.CrossOrigin; // Fixed import
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // Fixed import

import com.library.library_management.model.BorrowRequest;
import com.library.library_management.service.BorrowRecordService;
@RestController
@RequestMapping("/api/borrow")
@CrossOrigin
public class BorrowController {
    private final BorrowRecordService borrowRecordService;
    public BorrowController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService=borrowRecordService;
    }
    @PostMapping // Added the missing annotation!
    public String BorrowBookString(@RequestBody BorrowRequest borrowRequest){
        Long bookId=borrowRequest.getBookId();
        Long userId=borrowRequest.getUserId();
        return borrowRecordService.borrowBook(bookId, userId);
    }
}

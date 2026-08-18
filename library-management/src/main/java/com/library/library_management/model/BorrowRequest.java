package com.library.library_management.model;

// This isn't a database table (No @Entity). It's just a temporary box to catch the JSON!
public class BorrowRequest {
    private Long bookId;
    private Long userId;

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
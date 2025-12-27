package com.lms.controller;

import com.lms.enums.BookType;
import com.lms.response.ApiResponse;
import com.lms.response.BookResponse;
import com.lms.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String isbn,
            @RequestParam BookType type) {

        BookResponse response = bookService.addBook(title, author,isbn, type);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Book added successfully", response)
        );
    }

    @GetMapping("/{bookItemId}")
    public ResponseEntity<ApiResponse<BookResponse>> getBook(
            @PathVariable Long bookItemId) {

        BookResponse response = bookService.getBook(bookItemId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Book fetched successfully", response)
        );
    }
}

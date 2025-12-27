package com.lms.controller;


import com.lms.response.ApiResponse;
import com.lms.response.BookIssueResponse;
import com.lms.response.ReturnBookResponse;
import com.lms.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoanController {

    private final LibraryService libraryService;


    @PostMapping("/issue")
    public ResponseEntity<ApiResponse<BookIssueResponse>> issueBook(
            @RequestParam Long bookItemId,
            @RequestParam Long memberId) {

        BookIssueResponse response = libraryService.issueBook(bookItemId, memberId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Book issued successfully",
                        response
                )
        );
    }

    @PostMapping("/return")
    public ResponseEntity<ApiResponse<ReturnBookResponse>> returnBook(
            @RequestParam Long bookItemId,
            @RequestParam Long memberId) {

        ReturnBookResponse response = libraryService.returnBook(bookItemId, memberId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Book returned successfully",
                        response
                )
        );
    }
}

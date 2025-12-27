package com.lms.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class BookIssueResponse {
    private Long bookItemId;
    private String bookTitle;

    private Long memberId;
    private String memberName;
    private String memberEmail;

    private LocalDate issueDate;
    private LocalDate dueDate;
}

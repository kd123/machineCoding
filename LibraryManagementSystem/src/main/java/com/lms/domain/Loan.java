package com.lms.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private BookItem bookItem;

    @ManyToOne
    private Member member;

    private LocalDate issueDate = LocalDate.now();
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    public Loan(BookItem bookItem, Member member) {
        this.bookItem = bookItem;
        this.member = member;
        this.dueDate = issueDate.plusDays(14); // 2 weeks loan period

    }

    public boolean isOverdue() {
        return returnDate != null && returnDate.isAfter(dueDate);
    }

}

package com.lms.domain;

import com.lms.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class BookItem {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Book book;

    private String barcode;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public synchronized boolean checkout() {
        if (status != BookStatus.AVAILABLE) return false;
        status = BookStatus.ISSUED;
        return true;
    }

    public synchronized void returnBook() {
        status = BookStatus.AVAILABLE;
    }
}

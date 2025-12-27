package com.lms.domain;

import com.lms.enums.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private BookType type;

}

package com.lms.factory;

import com.lms.domain.Book;
import com.lms.domain.BookItem;
import com.lms.enums.BookStatus;
import com.lms.enums.BookType;
import org.springframework.stereotype.Component;

/**
 * Factory class for creating BookItem instances.
 */
@Component
public class BookFactory {

    /**
     * Creates a Book instance based on the provided type.
     * @param title
     * @param author
     * @param type
     * @param isbn
     * @return Book instance
     */
    public Book createBook(String title, String author, String isbn, BookType type) {
        return switch (type) {
            case PHYSICAL -> Book.builder()
                    .title(title)
                    .author(author)
                    .isbn(isbn)
                    .type(BookType.PHYSICAL)
                    .build();
            case EBOOK -> Book.builder()
                    .title(title)
                    .author(author)
                    .isbn(isbn)
                    .type(BookType.EBOOK)
                    .build();
            default -> throw new IllegalArgumentException("Invalid book type");
        };
    }
}

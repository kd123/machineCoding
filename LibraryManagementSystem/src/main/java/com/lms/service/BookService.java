package com.lms.service;

import com.lms.domain.Book;
import com.lms.domain.BookItem;
import com.lms.enums.BookStatus;
import com.lms.enums.BookType;
import com.lms.factory.BookFactory;
import com.lms.repository.BookRepository;
import com.lms.response.BookResponse;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookFactory bookFactory;

    @Transactional
    public BookResponse addBook(
            String title,
            String author,
            String isbn,
            BookType type) {

        // ✅ FACTORY USAGE
        Book book = bookFactory.createBook(title, author, isbn, type);
        String barcode = "BOOK-" + System.currentTimeMillis();
        BookItem bookItem = BookItem.builder()
                .book(book)
                .barcode(barcode)
                .status(BookStatus.AVAILABLE)
                .build();
        bookRepository.save(bookItem);

        return BookResponse.from(bookItem);

    }

    @Transactional(readOnly = true)
    public BookResponse getBook(Long bookItemId) {

        BookItem bookItem = bookRepository.findById(bookItemId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        return BookResponse.from(bookItem);
    }
}

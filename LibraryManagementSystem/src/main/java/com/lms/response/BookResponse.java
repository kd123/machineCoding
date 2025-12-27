package com.lms.response;

import com.lms.domain.BookItem;
import lombok.Getter;

@Getter
public class BookResponse {

    private Long bookItemId;
    private String title;
    private String status;

    public static BookResponse from(BookItem bookItem) {
        BookResponse r = new BookResponse();
        r.bookItemId = bookItem.getId();
        r.title = bookItem.getBook().getTitle();
        r.status = bookItem.getStatus().name();
        return r;
    }
}

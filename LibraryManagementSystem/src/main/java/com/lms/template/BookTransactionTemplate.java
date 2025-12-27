package com.lms.template;

import com.lms.domain.BookItem;
import com.lms.domain.Member;
import com.lms.repository.*;
import com.lms.service.FineService;
import com.lms.service.NotificationService;
import jakarta.transaction.Transactional;

public abstract class BookTransactionTemplate<T> {

    protected BookRepository bookRepository;
    protected LoanRepository loanRepository;
    protected NotificationService notificationService;
    protected FineService fineService;

    @Transactional
    public final T execute(Long bookItemId, Member member) {

        // 1️⃣ CONCURRENCY HANDLED HERE (DB LOCK)
        BookItem bookItem = bookRepository.findByIdForUpdate(bookItemId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // 2️⃣ VALIDATION (custom per transaction)
        validate(bookItem, member);

        // 3️⃣ CORE TRANSACTION LOGIC
        return process(bookItem, member);

    }

    protected abstract void validate(BookItem bookItem, Member member);
    protected abstract T process(BookItem bookItem, Member member);
    protected abstract  void notifyMember(Member member, BookItem bookItem);

}

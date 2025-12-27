package com.lms.template;

import com.lms.domain.BookItem;
import com.lms.domain.Loan;
import com.lms.domain.Member;
import com.lms.enums.BookStatus;
import com.lms.response.ReturnBookResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReturnBookTransaction extends BookTransactionTemplate<ReturnBookResponse> {

    @Override
    protected void validate(BookItem bookItem, Member member) {
        if (bookItem.getStatus() != BookStatus.ISSUED)
            throw new RuntimeException("Not issued");
    }

    @Override
    protected ReturnBookResponse process(BookItem bookItem, Member member) {
        // Process the return of the book from the member
        bookItem.returnBook();
        bookRepository.save(bookItem);
        Loan loan = loanRepository.findActiveLoanByBookItemAndMember(bookItem, member);
        loan.setReturnDate(LocalDate.now());
        // Calculate fine if any
        double fine = fineService.calculateFine(loan);
        loan.setFine(fine);
        loan = loanRepository.save(loan);
        return ReturnBookResponse.builder()
                .bookItemId(bookItem.getId())
                .bookTitle(bookItem.getBook().getTitle())
                .memberId(member.getId())
                .memberName(member.getName())
                .memberEmail(member.getEmail())
                .returnDate(loan.getReturnDate())
                .fineAmount(fine).build();
    }
    @Override
    protected void notifyMember(Member member, BookItem bookItem) {
        // NOTIFY (Observer Pattern)
        notificationService.notify(member, bookItem, "RETURNED");
    }
}

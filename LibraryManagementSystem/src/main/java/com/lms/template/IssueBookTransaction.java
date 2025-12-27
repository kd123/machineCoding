package com.lms.template;

import com.lms.domain.BookItem;
import com.lms.domain.Loan;
import com.lms.domain.Member;
import com.lms.enums.BookStatus;
import com.lms.response.BookIssueResponse;
import org.springframework.stereotype.Component;


/* * Template class for issuing a book transaction.
 */
@Component
public class IssueBookTransaction extends BookTransactionTemplate<BookIssueResponse> {

    /**
     * Validate if the book can be issued to the member.
     * @param bookItem The book item to be issued.
     * @param member The member to whom the book is issued.
     */
    @Override
    protected void validate(BookItem bookItem, Member member) {
        // Validate if the book is available for issuing
        if (bookItem.getStatus() != BookStatus.AVAILABLE) {
            throw new IllegalStateException("Book is not available for issuing.");
        }
    }

    /**
     * Process the issuing of the book to the member.
     *
     * @param bookItem The book item to be issued.
     * @param member   The member to whom the book is issued.
     * @return
     */
    @Override
    protected BookIssueResponse process(BookItem bookItem, Member member) {
        // Process the issuing of the book to the member
        boolean issued = bookItem.checkout();
        if (!issued) {
            throw new IllegalStateException("Failed to issue the book.");
        }
        bookRepository.save(bookItem);
        Loan loan = loanRepository.save(new Loan(bookItem, member));
        return BookIssueResponse.builder()
                .bookItemId(bookItem.getId())
                .bookTitle(bookItem.getBook().getTitle())
                .memberId(member.getId())
                .memberName(member.getName())
                .memberEmail(member.getEmail())
                .issueDate(loan.getIssueDate())
                .dueDate(loan.getDueDate())
                .build();

    }
    /**
     * Notify the member about the issued book.
     * @param member The member to be notified.
     * @param bookItem The book item that was issued.
     */
    @Override
    protected void notifyMember(Member member, BookItem bookItem) {
        // NOTIFY (Observer Pattern)
        notificationService.notify(member, bookItem, "ISSUED");
    }
}

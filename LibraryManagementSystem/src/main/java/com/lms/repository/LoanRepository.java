package com.lms.repository;

import com.lms.domain.BookItem;
import com.lms.domain.Loan;
import com.lms.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("select l from Loan l where l.bookItem = :bookItem and l.member = :member and l.returnDate is null")
    Loan findActiveLoanByBookItemAndMember(BookItem bookItem, Member member);
}

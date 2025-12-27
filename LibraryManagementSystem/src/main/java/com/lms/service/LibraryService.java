package com.lms.service;

import com.lms.domain.BookItem;
import com.lms.domain.Member;
import com.lms.repository.*;
import com.lms.response.BookIssueResponse;
import com.lms.response.ReturnBookResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.lms.template.IssueBookTransaction;
import com.lms.template.ReturnBookTransaction;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final IssueBookTransaction issueTransaction;
    private final ReturnBookTransaction returnTransaction;


    @Transactional
    public BookIssueResponse issueBook(Long bookItemId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow();

        return issueTransaction.execute(bookItemId, member);
    }

    @Transactional
    public ReturnBookResponse returnBook(Long bookItemId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow();

        return returnTransaction.execute(bookItemId, member);
    }
}

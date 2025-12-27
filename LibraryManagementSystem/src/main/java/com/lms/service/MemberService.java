package com.lms.service;

import com.lms.domain.Member;
import com.lms.response.MemberResponse;
import com.lms.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse register(String name, String email) {

        Member member = Member.builder()
                .name(name)
                .email(email)
                .status(com.lms.enums.AccountStatus.ACTIVE)
                .build();
        memberRepository.save(member);

        return MemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("Member not found")
        );
        return MemberResponse.from(member);
    }
}

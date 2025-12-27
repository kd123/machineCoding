package com.lms.response;

import com.lms.domain.Member;
import lombok.Data;

@Data
public class MemberResponse {

    private Long memberId;
    private String name;
    private String email;

    public static MemberResponse from(Member member) {
        MemberResponse r = new MemberResponse();
        r.memberId = member.getId();
        r.name = member.getName();
        r.email = member.getEmail();
        return r;
    }
}

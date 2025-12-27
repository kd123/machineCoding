package com.lms.controller;

import com.lms.response.ApiResponse;
import com.lms.response.MemberResponse;
import com.lms.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponse>> registerMember(
            @RequestParam String name,
            @RequestParam String email) {

        MemberResponse response = memberService.register(name, email);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Member registered successfully", response)
        );
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> getMember(
            @PathVariable Long memberId) {

        MemberResponse response = memberService.getMember(memberId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Member fetched successfully", response)
        );
    }
}

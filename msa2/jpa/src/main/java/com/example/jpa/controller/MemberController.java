package com.example.jpa.controller;

import com.example.jpa.domain.request.MemberRequest;
import com.example.jpa.domain.response.MemberResponse;
import com.example.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public void postMember(@RequestBody MemberRequest memberRequest) {
        memberService.insertMember(memberRequest);
    }

    @GetMapping("/api/v1/members")
    public Page<MemberResponse> getMembersPage(
        // @RequestParam(defaultValue = "3", name = "size", required = false) Integer size,
        // @RequestParam(defaultValue = "0", name = "page", required = false) Integer page
        @PageableDefault(
            page = 0,
            size = 3,
            sort = "name",
            direction = Sort.Direction.DESC
        ) Pageable pageRequest
    ){
        // PageRequest pageRequest =
        //         PageRequest.of(page, size, Sort.by("name").descending());
        return memberService.getAllMembersPage(pageRequest);
    }
}

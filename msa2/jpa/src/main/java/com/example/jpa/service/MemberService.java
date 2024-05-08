package com.example.jpa.service;

import com.example.jpa.domain.entity.Member;
import com.example.jpa.domain.request.MemberRequest;
import com.example.jpa.domain.response.MemberResponse;
import com.example.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void insertMember(MemberRequest memberRequest) {
        memberRepository.save(memberRequest.toEntity());
    }

    public Page<MemberResponse> getAllMembersPage(Pageable pageRequest) {
        Page<Member> all = memberRepository.findAll(pageRequest);
        return all.map(MemberResponse::from);
    }
}

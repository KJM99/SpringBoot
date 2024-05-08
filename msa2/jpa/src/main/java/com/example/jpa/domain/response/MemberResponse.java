package com.example.jpa.domain.response;

import com.example.jpa.domain.entity.Member;

public record MemberResponse(
    String id, String name, String gender
) {
    public static MemberResponse from(Member member){
        return new MemberResponse(member.getId().toString(), member.getName(), member.getGender().name());
    }
}

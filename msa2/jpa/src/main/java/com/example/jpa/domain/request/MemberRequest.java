package com.example.jpa.domain.request;

import com.example.jpa.domain.entity.Member;
import com.example.jpa.type.Gender;

public record MemberRequest (
    String name, String gender
){
    public Member toEntity(){
        return Member.builder()
            .name(name)
            .gender(Gender.valueOf(gender))
            .build();
    }
}

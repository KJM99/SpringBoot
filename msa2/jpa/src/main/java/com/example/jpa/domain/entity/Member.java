package com.example.jpa.domain.entity;

import com.example.jpa.type.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBERS")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private UUID id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_GENDER")
    // "남" | "여" | "남자" | "여자" -> ENUM 사용
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}

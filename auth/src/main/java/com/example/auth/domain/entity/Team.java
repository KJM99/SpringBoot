package com.example.auth.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TEAMS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private UUID id;

    @Column(name = "TEAM_LEADER", unique = true)
    private String leader;

    @Column(name = "TEAM_SECRET")
    private String secret;

}

/*
 insert : 강사님
 요청 보낼 때
 API : api/v1/auth/token/parse
 method post
 header Authorization : Bearer ~.~.~
 body {
   leader: "김부자",
   secret: "7984"
 }
*/

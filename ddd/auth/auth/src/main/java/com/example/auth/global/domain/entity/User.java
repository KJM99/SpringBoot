package com.example.auth.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter @AllArgsConstructor
@NoArgsConstructor @Builder
@Table(name = "USERS")
//        , indexes = {@Index(columnList = "username")})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_NICKNAME")
    private String nickname;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)// 매핑된 필드의 이름을 가져와야 함
    private List<Playlist> playlists; // 순환 참조
}

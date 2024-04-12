package com.example.demo.domain;

import lombok.*;

@AllArgsConstructor             // 전부를 가지는 생성자
@NoArgsConstructor              // 아무것도 없는 생성자
@Getter
@Setter                 // getter, setter
@ToString
@EqualsAndHashCode    // toString, ?
@Builder                        //
public class User {
    private Long id;
    private String name;
    private String password;
    private String nickname;
}

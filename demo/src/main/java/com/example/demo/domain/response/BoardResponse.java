package com.example.demo.domain.response;

public record BoardResponse(int id, String content, String usersame) {
}

// board 로 요청이 오면
/*
    [id : 1, content: "1번", username: "kim"]
    [id : 2, content: "2번", username: "kim"]
    [id : 3, content: "3번", username: "park"]
 */
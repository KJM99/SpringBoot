package com.example.auth.dto.request;


// put
// ep /api/v1/auth
// body UpdateRequest
// update
public record UpdateRequest(String password, String nickname) {
}

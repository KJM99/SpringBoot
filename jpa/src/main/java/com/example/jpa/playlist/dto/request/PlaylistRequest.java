package com.example.jpa.playlist.dto.request;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;

public record PlaylistRequest (String plTitle, Long userId){

    public Playlist toEntity(){
        return Playlist.builder()
                .title(plTitle)
                .user(new User(userId, null, null, null,null))
                .build();
    }
}

package com.example.jpa.auth.dto.response;

import com.example.jpa.global.domain.dto.PlaylistDto;
import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public record UserResponse (Long id, String nickname, List<PlaylistDto> playlists){
    public static UserResponse from(User user) {
        // 내 방법
//        List<Playlist> playlist = user.getPlaylists();
//        List<PlaylistDto> playlistDtos = new ArrayList<>();
//        for (Playlist value : playlist) {
//            PlaylistDto playlistDto = new PlaylistDto(value.getId(), value.getPlTitle());
//            playlistDtos.add(playlistDto);
//        }

        // map 써보기
        List<PlaylistDto> list = user.getPlaylists()
                .stream()
                .map(playlist -> new PlaylistDto(playlist.getId(), playlist.getTitle()))
                .toList();

//        return new UserResponse(user.getId(), user.getNickname(), playlistDtos);
        return new UserResponse(user.getId(), user.getNickname(), list);
    }
}

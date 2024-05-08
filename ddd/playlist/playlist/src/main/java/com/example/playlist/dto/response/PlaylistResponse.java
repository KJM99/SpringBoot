package com.example.playlist.dto.response;

import com.example.playlist.global.domain.dto.UserDto;
import com.example.playlist.global.domain.entity.Playlist;

public record PlaylistResponse(Long id, String title, UserDto userDto) {

    public static PlaylistResponse from(Playlist playlist) {
//        User user = playlist.getUser();
        UserDto userDto = new UserDto(playlist.getUserId(), playlist.getNickname());

        return new PlaylistResponse(playlist.getId(), playlist.getTitle(), userDto);
    }
}

package com.example.jpa.playlist.service;

import com.example.jpa.global.domain.dto.UserDto;
import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.PlaylistRepository;
import com.example.jpa.playlist.dto.request.PlaylistRequest;
import com.example.jpa.playlist.dto.response.PlaylistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService{
    private final PlaylistRepository playlistRepository;

    @Override
    public void save(PlaylistRequest req) {
        playlistRepository.save(req.toEntity());
    }

    @Override
    public List<PlaylistResponse> getAll() {
        return playlistRepository.findAll()
                .stream()
                .map(PlaylistResponse::from).toList();


    }

    // 이건 Response 에 있어야할 로직
//    private static PlaylistResponse makeResponse(Playlist playlist) {
//        User user = playlist.getUser();
//        UserDto userDto = new UserDto(user.getId(), user.getNickname());
//
//        return new PlaylistResponse(playlist.getId(), playlist.getPlTitle(), userDto);
//    }
}

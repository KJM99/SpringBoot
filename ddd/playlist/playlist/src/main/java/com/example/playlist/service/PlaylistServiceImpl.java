package com.example.playlist.service;

import com.example.playlist.config.TokenInfo;
import com.example.playlist.dto.request.UpdateRequest;
import com.example.playlist.global.domain.entity.Playlist;
import com.example.playlist.global.domain.repository.PlaylistRepository;
import com.example.playlist.dto.request.PlaylistRequest;
import com.example.playlist.dto.response.PlaylistResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService{
    private final PlaylistRepository playlistRepository;


    @Override
    @Transactional
    public void updateUser(Long uid, UpdateRequest request) {
        playlistRepository.updateUserNickname(request.nickname(), uid);

    }

    @Override
    public void save(PlaylistRequest req, TokenInfo tokenInfo) {
        playlistRepository.save(req.toEntity(tokenInfo));
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

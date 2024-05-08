package com.example.playlist.service;

import com.example.playlist.config.TokenInfo;
import com.example.playlist.dto.request.PlaylistRequest;
import com.example.playlist.dto.request.UpdateRequest;
import com.example.playlist.dto.response.PlaylistResponse;

import java.util.List;

public interface PlaylistService {
    void save(PlaylistRequest req, TokenInfo tokenInfo);
    List<PlaylistResponse> getAll();
    void updateUser(Long uid, UpdateRequest request);
}

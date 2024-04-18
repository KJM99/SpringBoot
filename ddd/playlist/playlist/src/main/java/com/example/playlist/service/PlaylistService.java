package com.example.playlist.service;

import com.example.playlist.dto.request.PlaylistRequest;
import com.example.playlist.dto.response.PlaylistResponse;

import java.util.List;

public interface PlaylistService {
    void save(PlaylistRequest req);
    List<PlaylistResponse> getAll();

}

package com.example.demo.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlaylistResponse {
    private final String userName;
    private final String playlistName;
    private final Integer songCount;
}

/*
endpoint : /api/v1/playlists
method : GET
param : X
 */

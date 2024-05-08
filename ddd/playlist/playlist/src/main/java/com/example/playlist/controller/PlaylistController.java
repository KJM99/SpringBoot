package com.example.playlist.controller;

import com.example.playlist.config.JwtTokenUtils;
import com.example.playlist.config.TokenInfo;
import com.example.playlist.dto.request.PlaylistRequest;
import com.example.playlist.dto.request.UpdateRequest;
import com.example.playlist.dto.response.PlaylistResponse;
import com.example.playlist.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    end point: api/v1/playlists/user/:uid
    method: PUT
    body: UpdateRequest
    내 플레이 리스트에 있는 모든 것을 update 하는 로직을 만든다
*/


@RestController
@RequestMapping("/api/v1/playlists")
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
    private final JwtTokenUtils jwtTokenUtils;

    @PutMapping("/user/{uid}")
    public void updatePlaylist(@PathVariable("uid") Long uid, @RequestBody UpdateRequest request) {
        playlistService.updateUser(uid, request);
    }

    @PostMapping
    public void save(@RequestBody PlaylistRequest req, @RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.substring(7);
        TokenInfo tokenInfo = jwtTokenUtils.parseToken(token);
        playlistService.save(req, tokenInfo);
    }

    @GetMapping
    public List<PlaylistResponse> getAll(){
        return playlistService.getAll();
    }
}

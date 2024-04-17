package com.example.jpa;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.PlaylistRepository;
import com.example.jpa.global.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class InitData {
    @Autowired
    protected PlaylistRepository playlistRepository;
    @Autowired
    protected UserRepository userRepository;

    @BeforeEach
    void init(){
        for(int i = 0; i < 10; i++){
            User user = new User(null,
                    "user" + i,
                    "user" + i,
                    "user" + i,
                    null);
            userRepository.save(user);
            Playlist playlist = new Playlist(
                    null, "title" + i, user
            );
            playlistRepository.save(playlist);
        }
    }
}

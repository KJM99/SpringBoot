package com.example.auth.domain.entity;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    // select * from team where leader = ? and secret = ?
    Optional<Team> findByLeaderAndSecret(String leader, String secret);
}

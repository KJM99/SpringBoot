package com.example.jpa.global.domain.repository;

import com.example.jpa.global.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

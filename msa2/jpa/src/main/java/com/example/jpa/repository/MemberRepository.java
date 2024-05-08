package com.example.jpa.repository;

import com.example.jpa.domain.entity.Member;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    // Page<Member> findPage(PageRequest pageRequest);
    // @Query("select m from Member where Member.deleted = false")
}

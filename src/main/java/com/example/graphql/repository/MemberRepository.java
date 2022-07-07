package com.example.graphql.repository;

import com.example.graphql.entity.Board;
import com.example.graphql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

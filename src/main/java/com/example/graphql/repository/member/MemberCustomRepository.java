package com.example.graphql.repository.member;

import com.example.graphql.entity.Member;

import java.util.List;

public interface MemberCustomRepository {
    public Member getMemberByNo(Long no);

    List<Member> getAllMembers();
}

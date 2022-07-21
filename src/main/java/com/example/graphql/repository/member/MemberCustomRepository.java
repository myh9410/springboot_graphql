package com.example.graphql.repository.member;

import com.example.graphql.dto.request.MemberRequest;
import com.example.graphql.entity.Member;

import java.util.List;

public interface MemberCustomRepository {
    public Member getMemberByNo(Long no);

    public List<Member> getAllMembers();

    public Long updateMemberByNo(MemberRequest memberRequest);

    public Long deleteMemberByNo(Long no);
}

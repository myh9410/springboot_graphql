package com.example.graphql.repository.member;

import com.example.graphql.entity.Member;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

public interface MemberCustomRepository {
    public Member getMemberByNo(Long no);

}

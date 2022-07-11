package com.example.graphql.repository;

import com.example.graphql.entity.Member;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QOrder order = QOrder.order;

    public MemberCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Member getMemberByNo(Long no) {
        return jpaQueryFactory.selectFrom(member)
                .leftJoin(member.orders, order)
                .fetchJoin()
                .where(member.no.eq(no))
                .fetchOne();
    }

}

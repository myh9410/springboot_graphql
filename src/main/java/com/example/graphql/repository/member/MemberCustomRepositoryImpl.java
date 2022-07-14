package com.example.graphql.repository.member;

import com.example.graphql.entity.Member;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QOrder order = QOrder.order;

    public MemberCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
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

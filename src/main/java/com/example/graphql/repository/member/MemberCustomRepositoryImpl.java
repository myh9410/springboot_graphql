package com.example.graphql.repository.member;

import com.example.graphql.dto.request.MemberRequest;
import com.example.graphql.entity.Member;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

import java.util.List;

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

    @Override
    public List<Member> getAllMembers() {
        return jpaQueryFactory.selectFrom(member)
                .distinct()
                .leftJoin(member.orders, order)
                .fetchJoin()
                .orderBy(member.no.asc())
                .fetch();
    }

    @Override
    public Long updateMemberByNo(MemberRequest memberRequest) {
        JPAUpdateClause jpaUpdateClause = jpaQueryFactory.update(member);

        if (memberRequest.getActive() != null) {
            jpaUpdateClause.set(member.active, memberRequest.getActive());
        }

        return jpaUpdateClause.where(member.no.eq(memberRequest.getNo()))
                .execute();
    }

    @Override
    public Long deleteMemberByNo(Long no) {
        return jpaQueryFactory.delete(member)
                .where(member.no.eq(no))
                .execute();
    }


}

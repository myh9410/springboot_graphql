package com.example.graphql.repository;

import com.example.graphql.entity.Order;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrder order = QOrder.order;
    private final QMember member = QMember.member;

    public OrderCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Order getOrderByNoFetchJoin(Long no) {
        return jpaQueryFactory.selectFrom(order)
                .join(order.member, member)
                .fetchJoin()
                .where(order.no.eq(no))
                .fetchOne();
    }

    public Order getOrderByNoNormalJoin(Long no) {
        return jpaQueryFactory.selectFrom(order)
                .join(order.member, member)
                .where(order.no.eq(no))
                .fetchOne();
    }

}

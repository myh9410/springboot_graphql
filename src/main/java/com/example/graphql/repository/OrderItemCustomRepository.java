package com.example.graphql.repository;

import com.example.graphql.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrderItem orderItems = QOrderItem.orderItem;
    private final QOrder order = QOrder.order;

    public OrderItemCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public OrderItem getOrderItemsByNo(Long no) {
        return jpaQueryFactory.selectFrom(orderItems)
                .join(orderItems.order, order)
                .fetchJoin()
                .where(orderItems.no.eq(no))
                .fetchOne();
    }
}

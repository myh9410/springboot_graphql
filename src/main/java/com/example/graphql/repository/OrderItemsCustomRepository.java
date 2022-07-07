package com.example.graphql.repository;

import com.example.graphql.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderItemsCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrderItems orderItems = QOrderItems.orderItems;
    private final QOrders order = QOrders.orders;

    public OrderItemsCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public OrderItems getOrderItemsByNo(Long no) {
        return jpaQueryFactory.selectFrom(orderItems)
                .join(orderItems.order, order)
                .fetchJoin()
                .where(orderItems.no.eq(no))
                .fetchOne();
    }
}

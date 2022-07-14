package com.example.graphql.repository.orderitem;

import com.example.graphql.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderItemCustomRepositoryImpl implements OrderItemCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrderItem orderItems = QOrderItem.orderItem;
    private final QOrder order = QOrder.order;
    private final QItem item = QItem.item;

    public OrderItemCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public OrderItem getOrderItemsByNo(Long no) {
        return jpaQueryFactory.selectFrom(orderItems)
                .join(orderItems.order, order)
                .fetchJoin()
                .join(orderItems.item, item)
                .fetchJoin()
                .where(orderItems.no.eq(no))
                .fetchOne();
    }
}

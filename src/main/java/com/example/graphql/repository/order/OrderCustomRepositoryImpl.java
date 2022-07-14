package com.example.graphql.repository.order;

import com.example.graphql.entity.Order;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.example.graphql.entity.QOrderItem;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderCustomRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrder order = QOrder.order;
    private final QMember member = QMember.member;
    private final QOrderItem orderItem = QOrderItem.orderItem;

    public OrderCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Order getOrderByNo(Long no) {
        return jpaQueryFactory.selectFrom(order)
                .join(order.member, member)
                .fetchJoin()
                .leftJoin(order.orderItems, orderItem)
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

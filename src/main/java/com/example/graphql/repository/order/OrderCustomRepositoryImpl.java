package com.example.graphql.repository.order;

import com.example.graphql.dto.enums.OrderStatus;
import com.example.graphql.dto.request.OrderRequest;
import com.example.graphql.entity.Order;
import com.example.graphql.entity.QMember;
import com.example.graphql.entity.QOrder;
import com.example.graphql.entity.QOrderItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QOrder order = QOrder.order;
    private final QMember member = QMember.member;
    private final QOrderItem orderItem = QOrderItem.orderItem;

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

    public List<Order> getAllOrders() {
        return jpaQueryFactory.selectFrom(order)
                .distinct()
                .join(order.member, member)
                .fetchJoin()
                .leftJoin(order.orderItems, orderItem)
                .fetchJoin()
                .orderBy(order.no.asc())    //오름차순 정렬
                .fetch();
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return jpaQueryFactory.selectFrom(order)
                .distinct()     //SQL의 DISTINCT & ENTITY의 DISTINCT를 전부 다 수행한다.
                .join(order.member, member)
                .fetchJoin()
                .leftJoin(order.orderItems, orderItem)
                .fetchJoin()
                .where(order.status.eq(status))
                .fetch();
    }

    public Long updateOrderByNo(OrderRequest orderRequest) {

        JPAUpdateClause jpaUpdateClause = jpaQueryFactory.update(order);

        if (orderRequest.getOrderNum() != null) {
            jpaUpdateClause.set(order.orderNum, orderRequest.getOrderNum());
        }

        if (orderRequest.getStatus() != null) {
            jpaUpdateClause.set(order.status, orderRequest.getStatus());
        }

        return jpaUpdateClause.where(order.no.eq(orderRequest.getNo()))
                .execute();
    }

    public Long deleteOrderByNo(Long no) {
        return jpaQueryFactory.delete(order)
                .where(order.no.eq(no))
                .execute();
    }

}

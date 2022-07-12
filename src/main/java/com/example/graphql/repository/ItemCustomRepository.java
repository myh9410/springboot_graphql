package com.example.graphql.repository;

import com.example.graphql.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ItemCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QItem item = QItem.item;
    private final QOrderItem orderItem = QOrderItem.orderItem;

    public ItemCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Item getItemByNo(Long no) {
        return jpaQueryFactory.selectFrom(item)
                .leftJoin(item.orderItems, orderItem)
                .fetchJoin()
                .where(item.no.eq(no))
                .fetchOne();
    }

}

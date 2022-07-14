package com.example.graphql.repository.item;

import com.example.graphql.entity.Item;
import com.example.graphql.entity.QItem;
import com.example.graphql.entity.QOrderItem;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemCustomRepositoryImpl implements ItemCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QItem item = QItem.item;
    private final QOrderItem orderItem = QOrderItem.orderItem;

    public ItemCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
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

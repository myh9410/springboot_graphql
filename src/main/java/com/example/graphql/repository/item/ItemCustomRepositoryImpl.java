package com.example.graphql.repository.item;

import com.example.graphql.dto.request.ItemRequest;
import com.example.graphql.entity.Item;
import com.example.graphql.entity.QItem;
import com.example.graphql.entity.QOrderItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

import java.util.List;

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

    @Override
    public List<Item> getAllItems() {
        return jpaQueryFactory.selectFrom(item)
                .distinct()
                .leftJoin(item.orderItems, orderItem)
                .fetchJoin()
                .orderBy(item.no.asc())
                .fetch();
    }

    @Override
    public List<Item> getItemsInType(String type) {
        return jpaQueryFactory.selectFrom(item)
                .leftJoin(item.orderItems, orderItem)
                .fetchJoin()
                .where(item.type.in(type))
                .fetch();
    }

    @Override
    public Long updateItemByNo(ItemRequest itemRequest) {
        JPAUpdateClause jpaUpdateClause = jpaQueryFactory.update(item);

        if (itemRequest.getName() != null) jpaUpdateClause.set(item.name, itemRequest.getName());
        if (itemRequest.getPrice() != 0) jpaUpdateClause.set(item.price, itemRequest.getPrice());
        if (itemRequest.getType() != null) jpaUpdateClause.set(item.type, itemRequest.getType());

        return jpaUpdateClause.where(item.no.eq(itemRequest.getNo()))
                .execute();
    }

    @Override
    public Long deleteItemByNo(Long no) {
        return jpaQueryFactory.delete(item)
                .where(item.no.eq(no))
                .execute();
    }

}

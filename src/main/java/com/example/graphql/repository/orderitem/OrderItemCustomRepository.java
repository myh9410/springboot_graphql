package com.example.graphql.repository.orderitem;

import com.example.graphql.entity.OrderItem;

public interface OrderItemCustomRepository {

    public OrderItem getOrderItemsByNo(Long no);
}

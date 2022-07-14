package com.example.graphql.repository.order;

import com.example.graphql.entity.Order;

public interface OrderCustomRepository {
    public Order getOrderByNo(Long no);

    public Order getOrderByNoNormalJoin(Long no);
}

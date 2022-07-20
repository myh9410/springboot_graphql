package com.example.graphql.repository.order;

import com.example.graphql.dto.enums.OrderStatus;
import com.example.graphql.dto.request.OrderRequest;
import com.example.graphql.entity.Order;

import java.util.List;

public interface OrderCustomRepository {
    public Order getOrderByNo(Long no);

    public Order getOrderByNoNormalJoin(Long no);

    List<Order> getAllOrders();

    List<Order> getOrdersByStatus(OrderStatus status);

    public Long updateOrderByNo(OrderRequest orderRequest);

    public Long deleteOrderByNo(Long no);
}

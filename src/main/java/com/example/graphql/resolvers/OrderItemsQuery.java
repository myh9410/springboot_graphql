package com.example.graphql.resolvers;

import com.example.graphql.entity.OrderItems;
import com.example.graphql.entity.Orders;
import com.example.graphql.service.OrderItemsService;
import com.example.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemsQuery implements GraphQLQueryResolver {

    private final OrderItemsService orderItemsService;

    public OrderItems getOrderItemsByNo(Long no) {
        return orderItemsService.getOrderItemsByNo(no);
    }

}

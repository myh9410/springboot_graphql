package com.example.graphql.resolvers;

import com.example.graphql.entity.OrderItem;
import com.example.graphql.service.OrderItemsService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemsQuery implements GraphQLQueryResolver {

    private final OrderItemsService orderItemsService;

    public OrderItem getOrderItemsByNo(Long no) {
        return orderItemsService.getOrderItemsByNo(no);
    }

}

package com.example.graphql.resolvers.query;

import com.example.graphql.dto.response.OrderItemResponse;
import com.example.graphql.service.OrderItemsService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemsQuery implements GraphQLQueryResolver {

    private final OrderItemsService orderItemsService;

    public OrderItemResponse getOrderItemsByNo(Long no) {
        return orderItemsService.getOrderItemsByNo(no);
    }

}

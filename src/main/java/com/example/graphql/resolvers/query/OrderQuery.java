package com.example.graphql.resolvers.query;

import com.example.graphql.dto.response.OrderResponse;
import com.example.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderQuery implements GraphQLQueryResolver {

    private final OrderService orderService;

    public OrderResponse getOrderByNo(Long no) {
        return orderService.getOrderByNo(no);
    }

}

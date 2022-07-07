package com.example.graphql.resolvers;

import com.example.graphql.entity.Orders;
import com.example.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderQuery implements GraphQLQueryResolver {

    private final OrderService orderService;

    public Orders getOrderByNo(Long no) {
        return orderService.getOrderByNo(no);
    }

}

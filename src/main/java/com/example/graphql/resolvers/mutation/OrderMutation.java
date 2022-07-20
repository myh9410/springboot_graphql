package com.example.graphql.resolvers.mutation;

import com.example.graphql.dto.request.OrderRequest;
import com.example.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMutation implements GraphQLMutationResolver {

    private final OrderService orderService;

    public Long saveOrder(OrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }

    public Long putOrder(OrderRequest orderRequest) {
        return orderService.putOrder(orderRequest);
    }

    public Boolean deleteOrder(Long no) {
        return orderService.deleteOrder(no);
    }

}

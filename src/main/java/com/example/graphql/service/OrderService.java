package com.example.graphql.service;

import com.example.graphql.dto.response.OrderResponse;
import com.example.graphql.entity.Order;
import com.example.graphql.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse getOrderByNo(Long no) {
//        Orders order = orderRepository.getOrderByNoNormalJoin(no); -- query 2번 수행

//        System.out.println(order.toString()); -> 순환참조로 인한 stackoverflow

        Order order = orderRepository.getOrderByNo(no);

        //비즈니스 로직

        return OrderResponse.builder()
                .order(order)
                .build();
    }

}

package com.example.graphql.service;

import com.example.graphql.dto.response.OrderItemResponse;
import com.example.graphql.entity.OrderItem;
import com.example.graphql.repository.orderitem.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemRepository orderItemsRepository;

    public OrderItemResponse getOrderItemsByNo(Long no) {

        OrderItem orderItems = orderItemsRepository.getOrderItemsByNo(no);

        return OrderItemResponse.builder()
                .orderItem(orderItems)
                .build();
    }

}

package com.example.graphql.service;

import com.example.graphql.entity.OrderItem;
import com.example.graphql.repository.OrderItemCustomRepository;
import com.example.graphql.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemCustomRepository orderItemsCustomRepository;
    private final OrderItemRepository orderItemsRepository;

    public OrderItem getOrderItemsByNo(Long no) {

        OrderItem orderItems = orderItemsCustomRepository.getOrderItemsByNo(no);

        return orderItems;
    }

}

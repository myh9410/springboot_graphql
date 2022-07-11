package com.example.graphql.service;

import com.example.graphql.entity.OrderItem;
import com.example.graphql.repository.OrderItemsCustomRepository;
import com.example.graphql.repository.OrderItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemsCustomRepository orderItemsCustomRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderItem getOrderItemsByNo(Long no) {

        OrderItem orderItems = orderItemsCustomRepository.getOrderItemsByNo(no);

        return orderItems;
    }

}

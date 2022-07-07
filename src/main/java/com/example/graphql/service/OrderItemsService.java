package com.example.graphql.service;

import com.example.graphql.entity.OrderItems;
import com.example.graphql.entity.Orders;
import com.example.graphql.repository.OrderCustomRepository;
import com.example.graphql.repository.OrderItemsCustomRepository;
import com.example.graphql.repository.OrderItemsRepository;
import com.example.graphql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderItemsService {

    private final OrderItemsCustomRepository orderItemsCustomRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderItems getOrderItemsByNo(Long no) {

        OrderItems orderItems = orderItemsCustomRepository.getOrderItemsByNo(no);

        return orderItems;
    }

}

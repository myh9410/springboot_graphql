package com.example.graphql.service;

import com.example.graphql.dto.enums.OrderStatus;
import com.example.graphql.dto.request.OrderRequest;
import com.example.graphql.dto.response.OrderResponse;
import com.example.graphql.entity.Order;
import com.example.graphql.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();

        //비즈니스 로직

        return orders.stream()
                .map(order -> OrderResponse.builder().order(order).build())
                .collect(Collectors.toList());
    }

    public List<OrderResponse> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.getOrdersByStatus(status);

        //비즈니스 로직

        return orders.stream()
                .map(order -> OrderResponse.builder().order(order).build())
                .collect(Collectors.toList());
    }

    @Transactional
    public Long saveOrder(OrderRequest orderRequest) {
        Order order = orderRepository.save(orderRequest.toEntity());

        return order.getNo();
    }

    @Transactional
    public Long putOrder(OrderRequest orderRequest) {

        Long updatedRows = orderRepository.updateOrderByNo(orderRequest);

        System.out.println("update - updatedRows : " + updatedRows);

        return orderRequest.getNo();

    }

    public Boolean deleteOrder(OrderRequest orderRequest) {
        return true;
    }
}

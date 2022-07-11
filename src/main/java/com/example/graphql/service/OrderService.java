package com.example.graphql.service;

import com.example.graphql.entity.Order;
import com.example.graphql.repository.OrderCustomRepository;
import com.example.graphql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderCustomRepository orderCustomRepository;
    private final OrderRepository orderRepository;

    public Order getOrderByNo(Long no) {
//        Orders order = orderRepository.findById(no).orElseThrow(() -> {
//            throw new RuntimeException("에러");
//        });

//        Orders order2 = orderCustomRepository.getOrderByNoNormalJoin(no); -- query 2번 수행

        Order order = orderCustomRepository.getOrderByNoFetchJoin(no);

//        System.out.println(order.toString()); -- stackoverflow

        return order;
    }

}

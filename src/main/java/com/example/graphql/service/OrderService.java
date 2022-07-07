package com.example.graphql.service;

import com.example.graphql.entity.Orders;
import com.example.graphql.repository.OrderCustomRepository;
import com.example.graphql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderCustomRepository orderCustomRepository;
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public Orders getOrderByNo(Long no) {
//        Orders order = orderRepository.findById(no).orElseThrow(() -> {
//            throw new RuntimeException("에러");
//        });

//        Orders order2 = orderCustomRepository.getOrderByNoNormalJoin(no); -- query 2번 수행

        Orders order = orderCustomRepository.getOrderByNoFetchJoin(no);

//        System.out.println(order.toString()); -- stackoverflow

        return order;
    }

}
